package com.yhh.playground.mybatis;

import com.yhh.playground.mybatis.dao.OrderMapper5;
import com.yhh.playground.mybatis.dao.RoleMapper5;
import com.yhh.playground.mybatis.dao.UserMapper5;
import com.yhh.playground.mybatis.entity.Order;
import com.yhh.playground.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 注解
 */
public class T005 {


    private SqlSession sqlSession;
    private OrderMapper5 orderMapper;
    private UserMapper5 userMapper;
    private RoleMapper5 roleMapper;

    /**
     * 初始化 并 打开连接
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config5.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper5.class);
        userMapper = sqlSession.getMapper(UserMapper5.class);
        roleMapper = sqlSession.getMapper(RoleMapper5.class);
    }

    /**
     * 关闭连接
     */
    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void test1() {
        List<Order> all = orderMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void test2() {
        List<User> all = userMapper.findAllUserAndOrder();
        System.out.println(all);
    }

    @Test
    public void test3() {
        List<User> all = userMapper.findAllUserAndRole();
        System.out.println(all);
    }




}
