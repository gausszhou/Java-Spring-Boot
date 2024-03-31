package com.example.javaspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String index() {
        return "Hello, World! /";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! /hello";
    }

}
