package com.lucifer.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mr.Wang on 2016/11/26.
 */
public class MapUtils {

    /**
     * 从request中获得参数Map，并返回可读的Map
     */
    public static Map getParameterMap(HttpServletRequest request) throws Exception {
        // 参数Map
        Map properties = request.getParameterMap();
        //返回值Map
        Map resultMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String key = "", value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            key = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            resultMap.put(key, value);
        }
        return resultMap;
    }

    public static void doParameterMap(HttpServletRequest request) throws Exception {
        Map returnMap = new HashMap();
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = (String) enums.nextElement();
            String[] values = request.getParameterValues(paramName);
            for (int i = 1; i < values.length; i++) {
                System.out.println("[" + i + "]" + paramName + "" + values[i]);
            }
        }
    }
//    假设传递的参数个数不固定且参数名没有重复的，如何从后台得到呢？
//
//    Map map = new HashMap();
//
////得到枚举类型的参数名称，参数名称若有重复的只能得到第一个
//
//    Enumeration enum = this.getRequest().getParameterNames();
//   while (enum.hasMoreElements()) {
//        String paramName = (String) enum.nextElement();
//
//        String paramValue = this.getRequest().getParameter(paramName);
//
////形成键值对应的map
//        map.put(paramName, paramValue);
//
//    }

}
