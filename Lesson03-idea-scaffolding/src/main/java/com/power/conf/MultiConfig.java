package com.power.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MultiConfig {
    @Value("${spring.db.url}")
    private String dbUrl;

    @Value("${spring.data.redis.host}")
    private String redisPort;

    @Value("${app.name}")
    private String appName;

    public void printMultiConfig(){
        System.out.println(dbUrl + redisPort);
    }

    public void printAppName(){
        System.out.println(appName);
    }
}
