package com.power.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentConfig {

    //注入环境对象
    @Autowired
    private Environment env;

    public void printEnv(){
        //获取值
        String name = env.getProperty("app.name");

        //判断key存在
        if(env.containsProperty("app.name")){
            System.out.println("app.name存在配置项");
        }

        //读取key并转型
        Integer port = env.getProperty("app.port", Integer.class, 8080);

        System.out.println(name + port);
    }
}
