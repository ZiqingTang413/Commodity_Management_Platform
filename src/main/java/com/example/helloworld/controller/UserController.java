package com.example.helloworld.controller;
import com.example.helloworld.entity.User;


import com.example.helloworld.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @ApiOperation("get user by id") // swagger
    @GetMapping("user/{id}")
    public String getUserById(@PathVariable int id) { // @PathVariable: get variable from path
        System.out.println(id);
        return "Get user by id";
    }


    @Autowired // inject object of UserMapper
    private UserMapper userMapper;
    @GetMapping("/user")
    public List query() { // automatedly return json
        System.out.println("Querying all users...");
        List<User> list = userMapper.selectAllUser();
        System.out.println(list);
        return list;
    }

    @PostMapping("/user")
    public String saveUser(User user) {
        if(userMapper.insertUser(user) == 0){
            return "insert failed";
        }
        else{
            return "insert succeed";
        }
    }
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id) {
        System.out.println(id);
        userMapper.deleteUser(id);
        return "delete user by id";}

    @PutMapping("/user")
    public String updateUser(User user) {
        userMapper.updateById(user.getId(), user.getBirthday());
        return "update user by id";

    }

    /*
        select all users' orders
     */
    @GetMapping("/user/findAll")
    public String findAllOrder() {
        List<User> userList = userMapper.findAllUserAndOrder();
        System.out.println(userList);
        return "succeed";
    }



}
