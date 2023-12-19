package com.power.mvc;

import com.power.formatter.DeviceFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//添加注释
@Configuration
public class SelfDefineMvcConfig  implements WebMvcConfigurer {

    /**
     * 视图控制器 -- 无需创建Controller便可达到页面跳转功能
     * @param registry 视图跳转注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // WebMvcConfigurer.super.addViewControllers(registry);
        registry
                //添加路径
                .addViewController("/welcome")
                //跳转的文件名
                .setViewName("index");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
        //注册Device的格式转换
        registry.addFormatter(new DeviceFormatter());
    }
}
