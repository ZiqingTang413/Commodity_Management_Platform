package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsController {
    @RequestMapping(value="/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "Get request";
    }
    @RequestMapping(value="/getTest2", method = RequestMethod.GET)
    // http://localhost:8080/getTest2?username=XXX&phone=XXX
    public  String getTest2(String username, String phone) {
        System.out.println("username: " + username);
        System.out.println("phone: " + phone);
        return "Get request";

    }
    /*
        @RequestParam: mapping parameters' name, and makes the param required
        reqired = flase/true
     */
    @RequestMapping(value = "getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "username", required = false) String name) {
        System.out.println(name);
        return "Get request";
    }
    @RequestMapping(value = "postTest1", method = RequestMethod.POST)
    public String postTest1() {
        return "Post request";
    }

    @RequestMapping(value = "postTest2",method = RequestMethod.POST)
    public String postTest2(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "Post request";
    }


    @RequestMapping(value = "postTest3", method = RequestMethod.POST)
    public String postTest3(User user) {
        System.out.println(user);
        return "Post request";
    }

    /*
        the post is json: @RequestBody
     */
    @RequestMapping(value = "postTest4", method = RequestMethod.POST)
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "Post request: json";
    }

    /*
        ** - any path
        * - only one word
     */
    @GetMapping("hello/**")
    public String anyPath()
    {
        return "** any path";
    }

}
