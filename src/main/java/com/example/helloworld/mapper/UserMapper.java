package com.example.helloworld.mapper;

import com.example.helloworld.entity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> selectAllUser();

    @Insert("insert into user values (#{id}, #{username}, #{password}, #{birthday})")
    public int insertUser(User user); // return 0 - insert failed


    @Delete("delete from user where id = #{id}")
    public void deleteUser(int id);

    @Update("update user set birthday = #{birthday} where id = #{id}")
    public void updateById(int id, String birthday);

    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id")
            ,@Result(column = "username", property = "username")
            ,@Result(column = "password", property = "password")
            ,@Result(column = "birthday", property = "birthday")
            ,@Result(column = "id", property = "orders", javaType = List.class
            ,many = @Many(select = "com.example.helloworld.mapper.OrderMapper.selectOrderByUserId"))
    })
    public List<User> findAllUserAndOrder();


    @Select("select * from user where id = #{id}")
    public User selectUserById(int id);
}

