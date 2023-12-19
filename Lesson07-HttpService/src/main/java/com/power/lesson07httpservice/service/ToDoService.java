package com.power.lesson07httpservice.service;

import com.power.lesson07httpservice.model.ToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/**
 * 远程访问服务
 */
@Service
public interface ToDoService {

    /**
     * 一个方法就是一个远程服务
     * @param id
     * @return
     */
    //有可能会超时,多测试几遍就行
    @GetExchange ("/todos/{id}")
    ToDo getToDoById(@PathVariable("id") Integer id);


    @PostExchange("/todos/")
    ToDo createToDo(@RequestBody ToDo newToDo );


    @PutExchange("/posts/{id}")
    ResponseEntity<ToDo> update(@PathVariable Integer id ,@RequestBody ToDo toDo);

}
