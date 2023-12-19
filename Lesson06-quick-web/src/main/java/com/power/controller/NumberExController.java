package com.power.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberExController {

    @RequestMapping("/divide")
    public String some(Integer n1,Integer n2){
        int result = n1/n2;
        return "n1/n2 = " + result;
    }
}
