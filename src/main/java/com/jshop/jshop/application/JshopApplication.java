package com.jshop.jshop.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jshop.jshop.*"})
@MapperScan(value = "tk.mybatis.mapper.annotation",
        basePackages = {"com.jshop.jshop.mapper"}
)
public class JshopApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JshopApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JshopApplication.class);
    }

}
