package com.example.helloworld;

import org.mapstruct.Mapper;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.helloworld.mapper")
public class HelloworldApplication {

	public static void main(String[] args) {
		System.out.println("running");

		SpringApplication.run(HelloworldApplication.class, args);
	}

}
