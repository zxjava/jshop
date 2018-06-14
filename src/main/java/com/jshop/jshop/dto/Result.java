package com.jshop.jshop.dto;

import com.alibaba.fastjson.JSONObject;

public class Result {

    public static final Integer SUCCESS = 200;
    public static final Integer ERROR_PARAMS = 400;
    public static final String MSG_ERROR_PARAMS = "参数错误";
    public static final Integer ERROR_SYSTEM = 500;
    public static final String MSG_ERROR_SYSTEM = "系统错误";
    public static final Integer ERROR_AUTH = 401;
    public static final String MSG_ERROR_AUTH = "没有权限";

    private Integer code = SUCCESS;
    private Object data = new JSONObject();
    private String msg = "";
    private Page page = new Page(1, 10, 0);

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = null == data ? new JSONObject() : data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
