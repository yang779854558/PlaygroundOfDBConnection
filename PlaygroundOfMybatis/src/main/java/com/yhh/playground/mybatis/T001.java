package com.yhh.playground.mybatis;

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
 * 普通方式
 */
public class T001 {

    private SqlSession sqlSession;

    /**
     * 初始化 并 打开连接
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config1.xml");
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
     * 测试增删改查
     */
    @Test
    public void test1() throws Exception {
        sqlSession.delete("user.deleteById", 4);

        List<User> userList = sqlSession.selectList("user.selectAll");
        System.out.println("插入前：" + userList);

        User user = new User();
        user.setId(4);
        user.setUsername("sh");
        user.setPassword("123");
        sqlSession.insert("user.insert", user);
        System.out.println("插入用户4");
        List<User> userList2 = sqlSession.selectList("user.selectAll");
        System.out.println("插入后：" + userList2);
        System.out.println("增加了：" + sqlSession.selectOne("user.selectOneById", 4));

        user.setUsername("yhh2");
        sqlSession.update("updateById", user);
        System.out.println("修改用户 4");
        System.out.println("变为：" + sqlSession.selectOne("user.selectOneById", 4));

        sqlSession.delete("user.deleteById", 4);
        System.out.println("删除用户4");
        System.out.println("删除后：" + (sqlSession.selectList("user.selectAll")));

    }

}
