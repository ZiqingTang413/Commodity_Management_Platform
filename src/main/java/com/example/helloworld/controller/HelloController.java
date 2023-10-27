package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
        @GetMapping("/hello")
        @RequestMapping(value = "/hello",method= RequestMethod.GET)
        are the same


        how to receive the values sent by the browser?
        - http://localhost/hello?username=Alice&phone=123
     */
    // @GetMapping("/hello")
    @RequestMapping(value = "/hello",method= RequestMethod.GET) // restrict to Get request only
    public String hello(String username, String phone) {
        System.out.println(phone);
        return "Hello " + username;
    }

}