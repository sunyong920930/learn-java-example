package lean.java.example.spring.annotation;

import java.lang.annotation.*;

/**
 * Created by sunyong on 2018-08-09.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestLimit {

    /**
     * 允许访问的次数，默认值1000
     */
    int[] count() default 1000;

    /**
     * 允许访问的次数的时间段，单位为秒，默认值一分钟,
     */
    long[] timeSlot() default 60;

    /**
     * 触发封禁后的时长，单位为秒，默认值五分钟
     *
     * @return
     */
    long[] blockTime() default 5 * 60;

    /**
     * 限流类型
     *
     * @return
     */
    RequestLimitType type() default RequestLimitType.URI_IP_USER_ID;
}
