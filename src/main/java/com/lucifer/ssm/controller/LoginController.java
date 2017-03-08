package com.lucifer.ssm.controller;

import com.lucifer.ssm.service.login.ILoginService;
import com.lucifer.ssm.utils.MapUtils;
import com.lucifer.ssm.utils.Util;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.wang on
 * 2016/11/2  23:51.
 */
@Controller
@Scope("prototype")
public class LoginController {

    @Resource
    ILoginService loginService;

    @RequestMapping(value = "/login")
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String IP = Util.getIpAddr(request);


        Map map = MapUtils.getParameterMap(request);

        String userName = (String) map.get("userName");
        String userPass = (String) map.get("password");


        HashMap<String, Object> loginMap = loginService.toLogin(map);
        if (loginMap == null || loginMap.isEmpty()) {
            return "toLoginPage";
        } else {
            return "/toHome";
        }
//        return null;
    }

    @RequestMapping(value = "/logout")
    public String Logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        session.invalidate();
        return "redirect: toLoginPage";
    }
}
