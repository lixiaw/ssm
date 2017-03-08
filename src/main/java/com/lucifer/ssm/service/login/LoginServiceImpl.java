package com.lucifer.ssm.service.login;

import com.lucifer.ssm.dao.login.LoginDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.wang on
 * 2016/11/4  16:06.
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Resource
    private LoginDao loginDao;

    public HashMap<String, Object> toLogin(Map map) {
        HashMap loginMap = null;
        try {
            loginMap = loginDao.doLogin(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginMap;
    }
}
