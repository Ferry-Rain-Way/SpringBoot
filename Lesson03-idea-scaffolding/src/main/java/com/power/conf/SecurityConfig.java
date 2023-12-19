package com.power.conf;

import com.power.pojo.Security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @ConfigurationProperties(prefix = "app.security")
    @Bean
    public Security createSecurity(){
        return new Security();
    }
}
