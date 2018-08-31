package lean.java.example.spring.annotation;

/**
 * Created by sunyong on 2018-08-09.
 * 限流方式
 */
public enum RequestLimitType {

    /**
     * 使用uri + "_" + ip作为限定方式
     */
    URI_IP,

    /**
     * 使用uri + "_" + userId作为限定方式
     */
    URI_USER_ID,

    /**
     * 使用uri + "_" + ip + "_" + userId作为限定方式,若userId未获取到，则使用 URI_IP 方式
     */
    URI_IP_USER_ID;
}
