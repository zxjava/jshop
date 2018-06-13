package com.jshop.jshop.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jshop.jshop.*"})
@MapperScan(basePackages = {"com.jshop.jshop.mapper"})
public class JshopApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JshopApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JshopApplication.class);
    }

}
