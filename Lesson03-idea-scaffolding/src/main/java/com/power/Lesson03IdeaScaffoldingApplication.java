package com.power;

import com.power.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:/applicationContext.xml")
@ConfigurationPropertiesScan({"com.power.conf"})
@SpringBootApplication
public class Lesson03IdeaScaffoldingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Lesson03IdeaScaffoldingApplication.class, args);
		Person myPerson = (Person) ctx.getBean("myPerson");
		System.out.println("myPerson = " + myPerson);
	}

}
