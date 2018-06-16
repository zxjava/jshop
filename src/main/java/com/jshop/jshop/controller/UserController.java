package com.jshop.jshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.jshop.jshop.dto.Result;
import com.jshop.jshop.exception.JshopException;
import com.jshop.jshop.exception.ParamterException;
import com.jshop.jshop.model.User;
import com.jshop.jshop.service.UserService;
import com.jshop.jshop.util.EncryptUtils;
import com.jshop.jshop.util.RegexUtil;
import com.jshop.jshop.util.StringUtil;
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

    @ApiOperation(value = "添加用户", notes = "返回添加的用户，[name/email/password] json格式，")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(@RequestBody(required = true) User user) throws JshopException,ParamterException {
        if (!RegexUtil.isPassword(user.getPassword())) {
            throw new ParamterException("密码为6-16位字母或数字的组合");
        }
        if (!RegexUtil.isUsernameCn(user.getName(), 2, 10)) {
            throw new ParamterException("用户名为长度为2-10的中文字符");
        }
        if (!RegexUtil.isEmail(user.getEmail())) {
            throw new ParamterException("email格式不正确");
        }

        user.setPasswordSalt(UUIDGenerator.getUUID());
        user.setPassword(EncryptUtils.encryptMD5(user.getPassword() + user.getPasswordSalt()));

        System.out.println(JSONObject.toJSONString(user));

        userService.addUser(user);
        Result res = new Result();
        res.setData(user);
        return res;
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
