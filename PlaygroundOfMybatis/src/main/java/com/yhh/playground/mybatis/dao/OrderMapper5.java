package com.yhh.playground.mybatis.dao;

import com.yhh.playground.mybatis.entity.Order;
import com.yhh.playground.mybatis.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper5 {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.yhh.playground.mybatis.dao.UserMapper5.findById"))
    })
    List<Order> findAll();


    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);

}
