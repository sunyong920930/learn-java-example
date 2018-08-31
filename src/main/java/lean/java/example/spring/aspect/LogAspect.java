package lean.java.example.spring.aspect;

import lean.java.example.spring.annotation.AroudAuthority;
import lean.java.example.spring.annotation.Desc;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * Created by sunyong on 2018-05-31.
 * 日志切面
 */
@Component
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切入点
     */
    @Pointcut("execution(* com.caiyi.financial.weixin.controller.*.*(..))")
    public void log() {

    }

    /**
     * 定义前置通知
     *
     * @param joinPoint
     */
    //@Before("@annotation(around)") /// 哪个方法走切面增强
    @Before("log()")
    public void logBefore(JoinPoint joinPoint/*, AroudAuthority around*/) {
        System.out.println("前置方法：logBefore");
        System.out.println("方法名：" + joinPoint.getSignature().getName());
        System.out.println("classType：" + joinPoint.getTarget().getClass().getName());
        Method method = getTargetMethod(joinPoint);
        if (method.isAnnotationPresent(Desc.class)) {// 判断某个方法上是否使用了某个注解
            String value = method.getAnnotation(Desc.class).value();// 获取注解上的内容
            System.out.println(value);
        }
    }

    /**
     * 环绕通知
     * 定义around增强，pointcut连接点使用@annotation(XXX)进行定义
     */
    //@Around(value = "@annotation(around)")
    public Object logArround(ProceedingJoinPoint proceedingJoinPoint, AroudAuthority around) throws Throwable {
        // 模拟认证是否通过
        System.out.println("### AroudAuthority is accept[success]");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("### " + around.methodName() + " exec result :" + result.toString());
        System.out.println("end");
        return result;
    }


    public static Method getTargetMethod(JoinPoint joinPoint) {
        Method targetMethod = null;
        try {
            String methodName = joinPoint.getSignature().getName();
            Method[] methodArr = joinPoint.getSignature().getDeclaringType().getMethods();
            for (Method method : methodArr) {
                if (method.getName().equals(methodName)) {
                    targetMethod = method;
                    break;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return targetMethod;
    }
}
