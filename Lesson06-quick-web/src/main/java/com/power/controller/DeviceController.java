package com.power.controller;

import com.power.pojo.DeviceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DeviceController {
    //http://localhost:8080/device/add?device=111,222,333,444,555
    @ResponseBody
    @RequestMapping("/device/add")
    public String deviceFromatterTest(
                @RequestParam("device")
                DeviceInfo deviceInfo){

        System.out.println(deviceInfo.toString());

        return "接收到的设备数据："+deviceInfo.toString();
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
