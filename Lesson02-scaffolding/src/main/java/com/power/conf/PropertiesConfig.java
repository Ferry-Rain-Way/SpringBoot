package com.power.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesConfig {
    @Value("${app.name:我叫张三}")
    private String name;

    public void printValue(){
        System.out.println(name);
    }
}
