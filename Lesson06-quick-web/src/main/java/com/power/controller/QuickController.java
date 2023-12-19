package com.power.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class QuickController {

    @RequestMapping("/exam/quick")
    public String quickRequest(Model model){
        //导入的Model包是springframework的
        model.addAttribute("title","Web-Quick 中文");
        model.addAttribute("time", LocalDateTime.now() );

        return "quick";
    }

}
