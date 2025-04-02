package com.yash.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cont {

    //mapping for /hello
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theData",new java.util.Date());
        return "helloWorld";
    }
}
