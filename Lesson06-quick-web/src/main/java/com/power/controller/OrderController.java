package com.power.controller;

import com.power.pojo.Order;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    /**
     * <a href="http://localhost:8080/order/new?name=%E7%9B%B8%E6%9C%BA&userId=20230426%2017&amount=1">...</a>
     * @param order
     * @return
     */
    @RequestMapping("/order/new")
    public String createOrder(@Validated Order order){

        return order.toString();
    }

}
