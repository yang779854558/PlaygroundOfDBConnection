package com.yhh.playground.mybatis;

import com.yhh.playground.mybatis.dao.UserMapper2;
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

public class T002 {

    private SqlSession sqlSession;

    private UserMapper2 userMapper2;


    /**
     * 初始化 并 打开连接
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config2.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper2 = sqlSession.getMapper(UserMapper2.class);
    }

    /**
     * 关闭连接
     */
    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void test1() throws Exception {
        userMapper2.deleteById(2);

        List<User> userList = userMapper2.selectAll();
        System.out.println("插入前：" + userList);

        User user = new User();
        user.setId(2);
        user.setUsername("sh");
        user.setPassword("123");
        userMapper2.insert(user);
        System.out.println("插入用户2");
        List<User> userList2 = userMapper2.selectAll();
        System.out.println("插入后：" + userList2);
        System.out.println("增加了：" + userMapper2.selectOneById(2));

        user.setUsername("yhh2");
        userMapper2.updateById(user);
        System.out.println("修改用户 2");
        System.out.println("变为：" + userMapper2.selectOneById(2));

        userMapper2.deleteById(2);
        System.out.println("删除用户2");
        System.out.println("删除后：" + (userMapper2.selectAll()));
    }
}
