package com.jshop.jshop.exception;

import com.jshop.jshop.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        Result result = new Result();
        result.setCode(Result.ERROR_SYSTEM);
        result.setMsg(Result.MSG_ERROR_SYSTEM);
        return result;
    }

    @ExceptionHandler(value = JshopException.class)
    @ResponseBody
    public Result jshopExceptionHandler(HttpServletRequest req, JshopException e) throws Exception{
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

}
