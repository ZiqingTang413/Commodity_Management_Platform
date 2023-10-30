package com.example.helloworld.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

public class Order {
    private int id;
    private String orderTime;
    private double orderPrice;
    private int uid;

    private User user; // one order is only related to one user

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime='" + orderTime + '\'' +
                ", orderPrice=" + orderPrice +
                ", uid=" + uid +
                ", user=" + user.toString() +
                '}';
    }
}
