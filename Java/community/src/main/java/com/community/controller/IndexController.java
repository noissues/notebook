package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 告诉 Spring 这是一个 Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/hello") // 确保对 /hello 的 Get 请求映射到 hello() 方法上
    public String hello(@RequestParam(name = "name", defaultValue = "root") String name,
                        Model model) {
        model.addAttribute("name", name); // 将 name 通过 Model 传出去
        return "hello";   // 返回名为 hello 的视图
    }
}
