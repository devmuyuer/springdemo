package com.muyuer.springdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  by muyuer
 * @date : 2018-11-30 14:22
 */
@Api("接口用途 XX接口")
@RestController
public class HelloController {

    @ApiOperation("描述方法用途 XX方法")
    @GetMapping("/hello")
    public String say(){
        return "Hello SpringBoot!";
    }

    @ApiOperation("描述方法用途 xx方法")
    @ApiImplicitParam(name = "name", value = "XX参数", dataType = "String")
    @GetMapping("/hello2")
    public String say2(String name){
        return name + ": Hello SpringBoot!";
    }
}