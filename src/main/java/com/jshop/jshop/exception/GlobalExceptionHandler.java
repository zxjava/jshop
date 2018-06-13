package com.jshop.jshop.exception;

import com.jshop.jshop.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e){
        Result result = new Result();
        toException(e);
        result.setCode(Result.ERROR_SYSTEM);
        result.setMsg(Result.MSG_ERROR_SYSTEM);
        return result;
    }

    @ExceptionHandler(value = JshopException.class)
    @ResponseBody
    public Result jshopExceptionHandler(HttpServletRequest req, JshopException e){
        toException(e);
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

    private void toException(Exception e){
        StackTraceElement[] ste = e.getStackTrace();
        for (StackTraceElement s:
             ste) {
            logger.error(s.toString());
        }
    }

}
