package com.mybatis;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // get a sqlsession object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get an object of UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        User userLisi = userMapper.selectByUsername();
        System.out.println(userLisi);
        sqlSession.close();

    }

}
