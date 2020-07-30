package com.yhh.playground.mybatis.dao;

import com.yhh.playground.mybatis.entity.User;

import java.util.List;

public interface UserMapper2 {

    void insert(User user);

    void deleteById(int id);

    void updateById(User user);

    List<User> selectAll();

    User selectOneById(int id);

}
