package com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        // load UserMapper.xml, get a SqlSessionFactory object
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // get a sqlsession object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // execute sql
        List<User> users = sqlSession.selectList("test.selectAll"); //param: "namespace.sql_query_id"
        System.out.println(users);
        sqlSession.close();
    }
}
