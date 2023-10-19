package com.mybatis.mapper;

import com.mybatis.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectByUsername();
}
