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

/**
 * 动态 SQL
 */
public class T003 {


    private SqlSession sqlSession;

    /**
     * 初始化 并 打开连接
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config3.xml");
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

    /**
     * findUserByIdAndUsername
     */
    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("yhh");
        boolean exist = sqlSession.selectOne("user3.findUserByIdAndUsername", user);
        System.out.println(exist);
    }

    @Test
    public void test2() throws Exception {
        int[] ids = new int[]{1, 2, 5};
        List<User> userList = sqlSession.selectList("user3.findByIds", ids);
        System.out.println(userList);
    }
}
