package com.jshop.jshop.exception;

import com.jshop.jshop.dto.Result;

public class JshopException extends Exception{

    private String msg;
    private Integer code;

    public JshopException() {
        super();
    }

    public JshopException(String msg) {
        super();
        this.setCode(Result.ERROR_SYSTEM);
        this.setMsg(msg);
    }

    public JshopException(Integer code, String msg) {
        super();
        this.setCode(code);
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
