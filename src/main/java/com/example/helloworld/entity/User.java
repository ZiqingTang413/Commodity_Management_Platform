package com.example.helloworld.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@Setter
@Getter
@ToString
@TableName("user") // in case class name and table name are different
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String birthday;

    @TableField(exist = false) // this field does not exist in user table, help to generate sql statements
    private List<Order> orders;

}
