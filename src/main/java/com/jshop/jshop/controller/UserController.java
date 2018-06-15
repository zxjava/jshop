package com.jshop.jshop.controller;

import com.jshop.jshop.dto.Result;
import com.jshop.jshop.model.User;
import com.jshop.jshop.service.UserService;
import com.jshop.jshop.util.EncryptUtils;
import com.jshop.jshop.util.UUIDGenerator;
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
        user.setName("张新杰");
        user.setEmail("857065019@qq.com");
        user.setPasswordSalt(UUIDGenerator.getUUID());
        user.setPassword(EncryptUtils.encryptMD5("123456" + user.getPasswordSalt()));
        Integer res = userService.addUser(user);
        System.out.println(res);
        System.out.println(user.getId());
        return user.getId().toString();
    }

    @ApiOperation(value = "根据用户id查询用户", notes = "根据用户主键id查询用户")
    @ApiImplicitParam(name = "id", paramType = "path", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        Result result = new Result();
        User user = userService.findById(id);
        user.setPasswordSalt("");
        result.setData(user);
        return user;
    }

}
