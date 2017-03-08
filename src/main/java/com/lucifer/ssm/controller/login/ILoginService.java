package com.lucifer.ssm.controller.login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.wang on
 * 2016/11/4  16:04.
 */

public interface ILoginService {

    HashMap<String, Object> toLogin(Map map);
}
