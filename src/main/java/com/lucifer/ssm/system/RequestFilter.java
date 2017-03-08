package com.lucifer.ssm.system;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by nelucifer on 2017/3/5.
 */
public class RequestFilter implements Filter {
    //过滤器初始化代码
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--->Loading RequestFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--->Loading RequestFilter doFilter...");
        //在这里可以对客户端请求进行检查
        //沿过滤器链将请求传递到下一个过滤器。

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        String path = request.getContextPath();
//        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";


        filterChain.doFilter(servletRequest, servletResponse);
        //在这里可以对响应进行处理
    }

    @Override
    public void destroy() {
        //过滤器被销毁时执行的代码
        System.out.println("--->Loading RequestFilter destroy...");
    }
}
