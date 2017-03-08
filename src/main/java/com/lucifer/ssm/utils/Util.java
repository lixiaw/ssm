package com.lucifer.ssm.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称：Util
 * 类描述：公用代码或者工具接口
 * 创建人：liuwensheng
 * 创建时间：2015-3-23 下午4:31:01
 * 修改人：liuwensheng
 * 修改时间：2015-3-23 下午4:31:01
 * 修改备注：
 */
public class Util {

    /**
     * 获取用户IP
     *
     * @param req
     * @return
     */
    public static String getIpAddr(HttpServletRequest req) {
        String ipAddress = null;
//        ipAddress = req.getRemoteAddr();
        ipAddress = req.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getRemoteAddr();
        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

}
