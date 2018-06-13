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

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception{


        System.out.println("----------------interceptor-------------------------");
        System.out.println(req.getRequestURL().toString());
        System.out.println(req.getPathInfo());
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getQueryString());
        System.out.println("----------------interceptor-------------------------");

        String basePath = req.getServletPath();
        if (!basePath.trim().startsWith("/api")) {
            res.setCharacterEncoding("utf-8");
            res.setHeader("Content-type", "application/json");
            Result result = new Result();
            result.setCode(Result.ERROR_AUTH);
            result.setMsg("非法请求");
            res.getWriter().write(JSON.toJSONString(result));
            res.getWriter().close();
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView view) throws Exception{

    }

    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception{

    }

}
