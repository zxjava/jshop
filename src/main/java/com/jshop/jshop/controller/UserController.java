package com.jshop.jshop.controller;

import com.jshop.jshop.dto.Result;
import com.jshop.jshop.model.User;
import com.jshop.jshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户管理")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "INDEX";
    }

    @ApiOperation(value = "添加用户", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String addUser(){
        User user = new User();
        user.setAge(25);
        user.setName("张新杰");
        Integer res = userService.addUser(user);
        System.out.println(res);
        System.out.println(user.getId());
        return user.getId().toString();
    }

    @ApiOperation(value = "根据用户id查询用户", notes = "根据用户主键id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserById(@PathVariable("id") Long id){
        Result result = new Result();
        User user = userService.findById(id);
        result.setData(user);
        return result;
    }

}
