package com.muyuer.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by muyuer
 * Time: 2016/12/16 15:45
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String say(){
        return "Hello SpringBoot!";
    }
}