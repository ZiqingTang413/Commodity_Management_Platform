package com.mybatis.mapper;

import com.mybatis.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    // select all rows from tb_brand
    List<Brand> selectAll();

    Brand selectById(int id);



}
