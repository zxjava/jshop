package com.jshop.jshop.mapper;

import com.jshop.jshop.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

//    @Insert("insert into user(name, email, password, password_salt) values(#{user.name}, #{user.email}, #{user.password}, #{user.passwordSalt})")
//    @Options(useGeneratedKeys = true, keyProperty = "user.id")
//    Integer insert(@Param("user") User user);

//    @Select("select * from user where name = #{name}")
//    @Results(id = "userMap", value = {
//            @Result(column = "id", property = "id", javaType = Long.class),
//            @Result(column = "name", property = "name", javaType = String.class),
//            @Result(column = "email", property = "email", javaType = String.class),
//            @Result(column = "password", property = "password", javaType = String.class),
//            @Result(column = "password_salt", property = "passwordSalt", javaType = String.class),
//            @Result(column = "create_time", property = "createTime", javaType = Date.class),
//    })
//    User findByName(@Param("name") String name);
//
//    @Select("select * from user where id = #{id}")
//    @ResultMap("userMap")
//    User findById(@Param("id") Long id);
}
