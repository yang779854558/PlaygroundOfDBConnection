package com.yhh.playground.mybatis;

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
 * 复杂映射开发
 */
public class T004 {


    private SqlSession sqlSession;

    /**
     * 初始化 并 打开连接
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config4.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
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
        List<Order> orderList = sqlSession.selectList("user4.findAllOrder");
        System.out.println(orderList);
    }

    @Test
    public void test2() {
        List<User> userList = sqlSession.selectList("user4.findAll1");
        System.out.println(userList);
    }

    @Test
    public void test3() {
        List<User> userList = sqlSession.selectList("user4.findAllUserAndRole");
        System.out.println(userList);
    }


}
