package com.jshop.jshop.service;

import com.jshop.jshop.mapper.UserMapper;
import com.jshop.jshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user){
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }

    public User findByName(String name){
        User user = new User();
        user.setName(name);
        return userMapper.selectOneByExample(user);
    }

    public User findById(Long id){
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }
}
