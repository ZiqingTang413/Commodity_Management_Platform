package com.mybatis.test;

import com.mybatis.mapper.BrandMapper;
import com.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1. get sqlSessionFactory object
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. get a new sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. get the Mapper interface object
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. test selectAll
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        // 5. close sqlSession
        sqlSession.close();

    }
    @Test
    public void selectByIdTest() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.selectById(2));

    }

}
