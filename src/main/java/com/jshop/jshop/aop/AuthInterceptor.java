package com.jshop.jshop.aop;

import com.alibaba.fastjson.JSON;
import com.jshop.jshop.dto.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    private final static String[] whiteList = {

    };

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception{


        System.out.println("----------------interceptor--begin-----------------------");
        System.out.println(req.getRequestURL().toString());
        System.out.println(req.getPathInfo());
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getQueryString());


        String basePath = req.getServletPath();
//        if (!basePath.trim().startsWith("/api")) {
//            System.out.println("9999999999999999999999999999999999999999999");
//            res.setCharacterEncoding("utf-8");
//            res.setHeader("Content-type", "application/json");
//            Result result = new Result();
//            result.setCode(Result.ERROR_AUTH);
//            result.setMsg("非法请求");
//            res.getWriter().write(JSON.toJSONString(result));
//            res.getWriter().close();
//            return false;
//        }
        System.out.println("----------------interceptor-doing------------------------");
        return true;
    }

    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView view) throws Exception{
        int status = res.getStatus();
        System.out.println("========返回状态码====》" + status);
        if (status != 200) {
            res.setCharacterEncoding("utf-8");
            res.setHeader("Content-type", "application/json");
            Result result = new Result();
            result.setCode(status);
            result.setMsg(Result.getErrorMsg(status));
            res.getWriter().write(JSON.toJSONString(result));
            res.getWriter().close();
        }
        System.out.println("----------------interceptor-end------------------------");
    }

    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception{

    }

}
