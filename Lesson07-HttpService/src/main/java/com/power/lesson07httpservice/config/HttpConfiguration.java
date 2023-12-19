package com.power.lesson07httpservice.config;

import com.power.lesson07httpservice.service.ToDoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * 创建一个普通Java类
 * 并用他代理ToDoService
 */
@Component
public class HttpConfiguration {

    //@Bean就放在方法上，就是让方法去产生一个Bean，然后交给Spring容器
    //创建服务接口的代理对象,基于WebClient\

    @Bean
    public ToDoService requestService(){
        //创建WebClient用于后续生成代理工厂
        WebClient webClient= WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();

        //创建代理工厂
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        //创建对象
        ToDoService toDoService = proxyFactory.createClient(ToDoService.class);

        return  toDoService;

    }





}
