package com.power.lesson07httpservice;

import com.power.lesson07httpservice.model.ToDo;
import com.power.lesson07httpservice.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class Lesson07HttpServiceApplicationTests {

	@Autowired
	ToDoService toDoService;

	@Test
	void testToDo(){
		ToDo todo = toDoService.getToDoById(1);
		System.out.println(todo);
	}

	@Test
	public  void testCreateToDo(){
		ToDo toDo = new ToDo(1021,200,"study SpringBoot",true);
		ToDo toDo1 = toDoService.createToDo(toDo);
		System.out.println(toDo1);

	}

	@Test
	public  void tesUpdateToDo(){
		ToDo todo = new ToDo(1021,1,"study SpringBoot",true);
		ResponseEntity<ToDo> rpEntity = toDoService.update(1, todo);

		System.out.println(rpEntity.getStatusCode());
		System.out.println(rpEntity.getBody());
		System.out.println(rpEntity.getHeaders());
		System.out.println(rpEntity.getClass());


	}
}
