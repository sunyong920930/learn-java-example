package lean.java.example.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunyong on 2018-08-31.
 */
public class IPUtil {

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.contains("192.168") || ip.contains("127.0.0")) {
                String xf = request.getHeader("X-Forwarded-For");
                if (xf != null) {
                    ip = xf.split(",")[0];
                }
            }
        }
        return ip;
    }

    public static String getClientIpAddress(HttpServletRequest request) {
        String ip = getIpAddress(request);
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
