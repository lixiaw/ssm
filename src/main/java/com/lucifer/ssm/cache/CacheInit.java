package com.lucifer.ssm.cache;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * 系统启动加载
 * Created by nelucifer on 2017/3/4.
 */
public class CacheInit extends HttpServlet {

    private static ServletContext servletContext = null;

    public void init() {
        servletContext = this.getServletContext();
    }

    public static ServletContext getServlerContextObject() {
        return servletContext;
    }
}
