package com.httpds.autoweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/hello")
@RestController
public class HelloController {
    @RequestMapping("/get")
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("result", "success");
	map.put("data","ayd");
        return map;
    }
}
