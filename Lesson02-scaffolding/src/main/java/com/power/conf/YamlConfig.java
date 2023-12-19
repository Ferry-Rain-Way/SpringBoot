package com.power.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class YamlConfig {
    @Value("${app.name}")
    private  String name;

    @Value("${app.port}")
    private Integer port;

   public  void printValue(){
        System.out.println(name);
    }
}
