package com.lucifer.ssm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据实体类
 * Created by Mr.Wang on 2016/12/23.
 */
public class ResponseJsonModel {
    private String status;
    private String code;
    private Map data = new HashMap();
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public void setResult(String status, String code, String message) {
        this.setStatus(status);
        this.setCode(code);
        this.setMessage(message);
    }

    public void setResult(String status, String message) {
        this.setStatus(status);
        this.setMessage(message);
    }

    public void setResult(String status, Map data, String message) {
        this.setStatus(status);
        this.setData(data);
        this.setMessage(message);
    }
}
