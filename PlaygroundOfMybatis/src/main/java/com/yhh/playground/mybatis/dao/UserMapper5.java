package com.yhh.playground.mybatis.dao;

import com.yhh.playground.mybatis.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper5 {

    @Select("select * from user where id = #{id}")
    User findById(int id);


    @Select("select * from user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "orderList",column = "id",
                    javaType = List.class,
                    many = @Many(select =
                            "com.yhh.playground.mybatis.dao.OrderMapper5.findByUid"))
    })
    List<User> findAllUserAndOrder();

    @Select("select * from user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "roleList",column = "id",
                    javaType = List.class,
                    many = @Many(select =
                            "com.yhh.playground.mybatis.dao.RoleMapper5.findByUid"))
    })
    List<User> findAllUserAndRole();

}
