package com.example.sprdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sprdemo.mapper")
public class SprDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprDemoApplication.class, args);
	}

}
