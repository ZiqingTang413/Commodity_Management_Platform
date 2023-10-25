package com.mybatis.mapper;

import com.mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // select all rows from tb_brand
    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByIdLess(int id);

    /*
        multiple parameters:
        1. @Param("")
        2. parameters of an object
        3. Map keys
     */

    /*List<Brand> selectByCondition(@Param("status") int status
                                , @Param("companyName") String companyName
                                , @Param("brandName") String brandName);
*/
   // List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);



}
