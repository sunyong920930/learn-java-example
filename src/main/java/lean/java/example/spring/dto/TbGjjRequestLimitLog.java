package lean.java.example.spring.dto;

import lombok.Data;

/**
 * Created by sunyong on 2018-08-31.
 * 限速日志记录表
 */
@Data
public class TbGjjRequestLimitLog {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 类型 1拦截日志 2封禁日志
     */
    private Integer type;
    /**
     * 允许访问的次数
     */
    private Integer count;
    /**
     * 允许访问的次数的时间段
     */
    private Long timeSlot;
    /**
     * 触发封禁的时长
     */
    private Long blockTime;
    /**
     * 当期访问的次数
     */
    private Long currentCount;
    /**
     * 请求的URI
     */
    private String requestUri;
    /**
     * 请求头
     */
    private String requestHeader;
    /**
     * 请求参数
     */
    private String requestParam;
    /**
     * 限定类型 URI_IP ， URI_USER_ID ， URI_IP_USER_ID
     */
    private String requestLimitType;
    /**
     * 请求ip
     */
    private String requestIp;
    /**
     * redis存储的key
     */
    private String key;
    /**
     * 日志内容
     */
    private String log;
}
