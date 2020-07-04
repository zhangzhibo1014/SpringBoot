package com.springboot.tkmybatis.controller;


import com.springboot.tkmybatis.domain.User;
import com.springboot.tkmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public String test() {
        return "测试Spring Boot";
    }

    @RequestMapping(value = "/all")
    public List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }
}
