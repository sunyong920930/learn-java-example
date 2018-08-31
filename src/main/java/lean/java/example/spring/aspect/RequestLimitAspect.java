package lean.java.example.spring.aspect;

import com.alibaba.fastjson.JSONObject;
import lean.java.example.spring.annotation.RequestLimit;
import lean.java.example.spring.annotation.RequestLimitType;
import lean.java.example.spring.dto.TbGjjRequestLimitLog;
import lean.java.example.utils.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunyong on 2018-08-09.
 */
@Aspect
@Component
public class RequestLimitAspect {

    private static final Logger logger = LoggerFactory.getLogger(RequestLimitAspect.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static String REQUEST_LIMIT_KEY_PREFIX = "req_limit_";

    @Before("execution(public * com.eshop.aop.controller..*.*(..)) && @annotation(limit)")
    public void requestLimitBefore(JoinPoint joinPoint, RequestLimit limit) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取userId
        String userId = "张三";
        String uri = request.getRequestURI();
        String ip = IPUtil.getIpAddress(request).replaceAll("[:]", "_");
        // 获取限流的key
        String key = generateKey(limit.type(), uri, userId, ip);
        //获得参数最小的长度，避免设置的参数长度不同导致的异常
        int[] lengthArr = {limit.count().length, limit.blockTime().length, limit.timeSlot().length};
        int minLength = minLength(lengthArr);
        String nameValuePairs = "";
        //高速率的梯度打印日志后  低速率的梯度就不打印日志
        boolean isFirstLogger = true;
        for (int i = minLength-1; i >= 0; i--) {
            int count = limit.count()[i];
            long blockTime = limit.blockTime()[i];
            long timeSlot = limit.timeSlot()[i];
            String currentKey = new StringBuilder().append(key).append("_").append(timeSlot).append("_").append
                    (count).toString();
            Long currentCount = redisTemplate.opsForValue().increment(currentKey, 1);
            // 获取过期时间
            Long expire = redisTemplate.getExpire(currentKey);
            if (currentCount == 1 || expire != null && expire != -1L) {
                // 设置过期时间
                redisTemplate.expire(currentKey, timeSlot, TimeUnit.SECONDS);
            }
            // 是否记录日志
            boolean logFlag = currentCount >= count && currentCount >= 10 && currentCount % 10 == 0 && isFirstLogger;
            // 是否封禁
            boolean blockFlag = currentCount == count;
            String header = JSONObject.toJSONString(getHeaders(request));
            String param = JSONObject.toJSONString(getArgs(joinPoint));
            nameValuePairs = new StringBuffer("key : ").append(currentKey).append(" ;\n header : ")
                    .append(header).append(" ;\n param : ").append(param).toString();
            //记录日志or封禁
            if (logFlag || blockFlag) {
                header = JSONObject.toJSONString(getHeaders(request));
                param = JSONObject.toJSONString(getArgs(joinPoint));
                String log = "";
                TbGjjRequestLimitLog message = new TbGjjRequestLimitLog();
                message.setCount(count);
                message.setTimeSlot(timeSlot);
                message.setBlockTime(blockTime);
                message.setCurrentCount(currentCount);
                message.setKey(currentKey);
                message.setRequestIp(ip);
                message.setUserId(userId);
                message.setRequestUri(uri);
                message.setRequestLimitType(limit.type().toString());
                //message.setCreateTime(new Date());
                //message.setUpdateTime(new Date());
                message.setRequestHeader(header != null && header.length() > 2000 ? header.substring(0, 2000) : header);
                message.setRequestParam(param != null && param.length() > 2000 ? param.substring(0, 2000) : param);
                //每累计10次打印一次日志
                if (logFlag) {
                    isFirstLogger = false;
                    String tempLimit = "用户[%s]请求拦截，IP[%s]访问地址[%s],[%s]秒内超过了限定的次数[%s],当前访问次数：[%s] ,key:[%s],请求头：%s," +
                            "参数：%s";
                    log = String.format(tempLimit, userId, ip, uri, timeSlot, count, currentCount, currentKey,
                            header, param);
                    logger.info("requestLimit : {}", log);
                    //message.setType(Constants.REQUEST_LIMIT_LOG_TYPE_LIMIT);
                    message.setLog(log != null && log.length() > 4000 ? log.substring(0, 4000) : log);
                    //message.setId(IDUtils.getUUID());
                    //tbGjjRequestLimitLogMapper.insertSelective(message);
                    //logger.info("记录接口限流拦截日志 , id : {}", message.getId());
                }
                //与限定的次数相同时  设置封禁时间
                if (blockFlag) {
                    String blockLimit = "用户[%s]已被封禁，封禁时长[%s],IP[%s]访问地址[%s],[%s]秒内超过了限定的次数[%s],当前访问次数：[%s] ,key:[%s]," +
                            "请求头：%s,参数：%s";
                    log = String.format(blockLimit, userId, formatTime(blockTime), ip, uri, timeSlot, count,
                            currentCount, currentKey, header, param);
                    logger.info("requestLimit : {}", log);
                    //设置封禁时间
                    redisTemplate.expire(currentKey, blockTime, TimeUnit.SECONDS);
                    //message.setType(Constants.REQUEST_LIMIT_LOG_TYPE_BLOCK);
                    message.setLog(log != null && log.length() > 4000 ? log.substring(0, 4000) : log);
                    //message.setId(IDUtils.getUUID());
                    //tbGjjRequestLimitLogMapper.insertSelective(message);
                    //logger.info("记录接口限流封禁日志 , id : {}", message.getId());
//                    redisTemplate.convertAndSend(Constants.REQUEST_LIMIT_LOG_TOPIC, message);
                }
            }
            //if (currentCount >= count) {
            //    Cat.logEvent(REQUEST_LIMIT_KEY_PREFIX + uri, userId, "Error", nameValuePairs);
            //    throw BizException.newInstance(-1, "访问太快，我快接不住了");
            //}
        }
    }

    private static String formatTime(long second) {
        String result = "";
        long hour = second / 3600;
        long minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        result += hour != 0 ? hour + "小时" : "";
        result += minute != 0 ? minute + "分钟" : "";
        result += second != 0 ? second + "秒" : "";
        return result;
    }

    private List<Object> getArgs(JoinPoint joinPoint) {
        List<Object> list = new ArrayList<>();
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object obj : args) {
                if (obj instanceof HttpServletRequest || obj instanceof HttpServletResponse) {
                    continue;
                }
                list.add(obj);
            }
        }
        return list;
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> header = new HashMap<>();
        Enumeration<String> e1 = request.getHeaderNames();
        while (e1.hasMoreElements()) {
            String headerName = e1.nextElement();
            String headerValue = request.getHeader(headerName);
            header.put(headerName, headerValue);
        }
        return header;
    }

    private int minLength(int[] lengthArr) {
        Integer result = Integer.MAX_VALUE;
        for (Integer value : lengthArr) {
            if (result > value) {
                result = value;
            }
        }
        return result;
    }

    private String generateKey(RequestLimitType limitType, String uri, String userId, String ip) {
        StringBuilder stringBuilder = new StringBuilder(REQUEST_LIMIT_KEY_PREFIX).append(uri).append("_");
        if (RequestLimitType.URI_IP_USER_ID.equals(limitType)) {
            if (StringUtils.isEmpty(userId)) {
                return stringBuilder.append(ip).toString();
            }
            return stringBuilder.append(ip).append("_").append(userId).toString();
        } else if (RequestLimitType.URI_IP.equals(limitType)) {
            return stringBuilder.append(ip).toString();
        } else if (RequestLimitType.URI_USER_ID.equals(limitType)) {
            if (userId == null) {
                userId = System.currentTimeMillis() + Math.random() + "";
                logger.warn("限流接口userId为空，使用随机限定：{}，uri：{}", userId, uri);
            }
            return stringBuilder.append(userId).toString();
        }
        return stringBuilder.toString();
    }
}
