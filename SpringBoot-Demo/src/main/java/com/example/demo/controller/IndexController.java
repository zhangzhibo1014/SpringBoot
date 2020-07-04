package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    /**
     * 模拟返回给浏览器JSON值
     * @return
     */
    @RequestMapping("/all")
    public Map findAll() {
        Map<Object, Object> map = new HashMap<Object, Object>();

        List<String> hobbys = new ArrayList<String>();
        hobbys.add("basketball");
        hobbys.add("football");

        map.put("code","100");
        map.put("message", "获取成功");
        map.put("data", hobbys);

        return map;
    }

    /**
    * HelloWorld
    */
    @RequestMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
