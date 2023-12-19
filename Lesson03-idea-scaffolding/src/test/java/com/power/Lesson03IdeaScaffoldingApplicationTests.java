package com.power;

import com.power.conf.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson03IdeaScaffoldingApplicationTests {

	@Autowired
	private MultiConfig multiConfig;

	@Test
	void testMultiConfig() {
//		multiConfig.printMultiConfig();
		multiConfig.printAppName();
	}

	@Autowired
	private Student student;

	@Test
	void testBean(){
		System.out.println(student);
		System.out.println(student.getClass());
	}

	@Autowired
	private NestAppBean nestAppBean;

	@Test
	void testNestAppBean(){
		System.out.println(nestAppBean);
	}

	@Autowired
	private SecurityConfig securityConfig;

	@Test
	void testSecurityConfig(){
		System.out.println(securityConfig.createSecurity());
	}

	@Autowired
	private CollectionConfig collectionConfig;
	@Test
	void testCollectionConfig() {
		String str = collectionConfig.toString();
		System.out.println("str = " + str);
	}

	@Autowired
	private Group group;
	@Test
	void testGroup() {
		System.out.println("group = " + group.toString());
	}
}
