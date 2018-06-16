package com.jshop.jshop.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${server.port}")
    private String port;
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.descrption}")
    private String description;
    @Value("${jshop.baseurl}")
    private String baseUrl;
    @Value("${jshop.version}")
    private String version;
    @Value("${jshop.created-by}")
    private String createBy;

    @Bean
    public Docket createResApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jshop.jshop.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        String basePath = baseUrl + ":" + port;
        return new ApiInfoBuilder()
                .title(title)
                .description(description + "\n 访问地址：" + basePath)
                .termsOfServiceUrl(basePath)
                .contact(createBy)
                .version(version)
                .build();
    }


}
