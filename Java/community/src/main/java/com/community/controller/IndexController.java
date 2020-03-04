package com.community.controller;

import com.community.mapper.UserMapper;
import com.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller // 告诉 Spring 这是一个 Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.findUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return "index";
    }
    
    @GetMapping("/hello") // 确保对 /hello 的 Get 请求映射到 hello() 方法上
    public String hello(@RequestParam(name = "name", defaultValue = "root") String name,
                        Model model) {
        model.addAttribute("name", name); // 将 name 通过 Model 传出去
        return "hello";   // 返回名为 hello 的视图
    }
}
