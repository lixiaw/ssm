package com.lucifer.ssm.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by nelucifer on 2017/3/5.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Value("toLoginPage")
    private String SSO_LOGIN_URL;

    public LoginInterceptor() {
    }

    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("---》Loading LoginInterceptor preHandle...");
        //1. 拦截请求URL
        //2. 从cookie中取出token
        //3. 如果没有token跳转到登录页面
        //4. 取到token
        //5. 如果session已经过期，跳转到登录页面

        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否是公开地址（实际使用时将公开地址配置到配置文件中）
        /*if (url.indexOf("ssm-web") >= 0) {
            //如果要登录提交，放行
            return true;
        }*/

        //判断session
        HttpSession session = request.getSession();
        //从session 中取出用户身份信息


//        response.sendRedirect(SSO_LOGIN_URL);
        return true;
        // 6、如果没有过期，放行。
//        return true;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("---》Loading LoginInterceptor postHandle...");
    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("---》Loading LoginInterceptor afterCompletion...");
    }
}
