package com.jshop.jshop.service;

import com.jshop.jshop.mapper.UserMapper;
import com.jshop.jshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user){
        return userMapper.insert(user);
    }

    public User findByName(String name){
        return userMapper.findByName(name);
    }

    public User findById(Long id){
        return userMapper.findById(id);
    }
}
