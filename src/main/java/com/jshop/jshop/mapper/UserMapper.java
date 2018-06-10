package com.jshop.jshop.mapper;

import com.jshop.jshop.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("insert into user(name, age) values(#{user.name}, #{user.age})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer insert(@Param("user") User user);

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Long id);
}
