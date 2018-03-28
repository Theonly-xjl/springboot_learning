package com.jkle.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xujiale
 * @create: 2018/03/27
 * @description:
 **/
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello () {
        return "HelloWorld!";
    }
}
