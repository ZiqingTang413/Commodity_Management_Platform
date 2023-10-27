package com.example.helloworld.controller;
import com.example.helloworld.entity.User;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @ApiOperation("get user by id") // swagger
    @GetMapping("user/{id}")
    public String getUserById(@PathVariable int id) { // @PathVariable: get variable from path
        System.out.println(id);
        return "Get user by id";
    }

    @PostMapping("/user")
    public String saveUser(User user) {return "add user";}

    @PutMapping("/user")
    public String updateUser(User user) {return "update user";}

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id) {
        System.out.println(id);
        return "delete user by id";

    }
}
