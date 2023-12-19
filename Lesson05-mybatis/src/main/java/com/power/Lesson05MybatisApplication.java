package com.power;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.power.mapper")
@SpringBootApplication
public class Lesson05MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson05MybatisApplication.class, args);
	}

}
