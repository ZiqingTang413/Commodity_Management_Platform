package com.example.helloworld.controller;

import com.example.helloworld.entity.Order;
import com.example.helloworld.mapper.OrderMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @ApiOperation("insert new order into table order")
    @PostMapping("/order")
    public String insertOrder(Order order) {
        if(orderMapper.insertOrder(order) == 0) return "insert failed";
        else return "insert succeed";
    }

    @GetMapping("/order/findAll")
    public String findAllOrderAndUser() {
        return orderMapper.selectAllOrderAndUser().toString();
    }
}
