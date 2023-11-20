package com.example.helloworld.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.entity.Order;
import com.example.helloworld.mapper.OrderMapper;
import io.swagger.annotations.ApiOperation;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    /*
        find all orders with pagination
     */
    @GetMapping("/order/findAll")
    public List<Order> findAllOrderAndUser(@RequestParam(defaultValue = "0") int pageNo
                                            ,@RequestParam(defaultValue = "10") int pageSize) {
        // create a new pae object
        Page<Order> page = new Page<>(pageNo, pageSize);

        orderMapper.selectAllOrderAndUser(page);
        // get the list of order


        return page.getRecords();
    }
}
