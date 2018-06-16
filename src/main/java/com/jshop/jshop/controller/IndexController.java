package com.jshop.jshop.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;
    @Value("${jshop.baseurl}")
    private String baseUrl;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        JSONObject res = new JSONObject();
        res.put("api", baseUrl + ":" + port + "/swagger-ui.html");
        return res.toJSONString();
    }

}
