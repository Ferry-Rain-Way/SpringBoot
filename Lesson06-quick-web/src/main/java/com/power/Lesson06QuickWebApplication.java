package com.power;

import com.power.pojo.BookContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties({BookContainer.class})
@SpringBootApplication

public class Lesson06QuickWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson06QuickWebApplication.class, args);
	}

}
