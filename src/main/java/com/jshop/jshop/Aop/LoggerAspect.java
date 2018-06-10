package com.jshop.jshop.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Before("execution(public * com.jshop.jshop.controller..*.*(..))")
    public void Before(JoinPoint p){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("==============================================");
        logger.info("URL : [" + request.getMethod() + "] " + request.getRequestURL().toString());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + p.getSignature().getDeclaringTypeName() + "."
                + p.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(p.getArgs()));
        logger.info("==============================================");
    }

}
