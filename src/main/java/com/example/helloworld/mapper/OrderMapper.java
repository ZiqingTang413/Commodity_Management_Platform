package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.entity.Order;
import com.example.helloworld.entity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order` values (#{id}, #{orderTime}, #{orderPrice}, #{uid})")
    public int insertOrder(Order order);

    @Select("select * from `order` where uid = #{uid}")
    public List<Order> selectOrderByUserId(int uid);

    /*
        select all orders and its owner's username
     */
    @Select("select * from `order`")
    @Results({
            @Result(column = "id", property = "id")
            ,@Result(column = "order_time", property = "orderTime")
            ,@Result(column = "order_price", property = "order_price")
            ,@Result(column = "uid", property = "user", javaType = User.class,
            one = @One(select = "com.example.helloworld.mapper.UserMapper.selectUserById"))
    })
    public Page<Order> selectAllOrderAndUser(Page<Order> page);

}
