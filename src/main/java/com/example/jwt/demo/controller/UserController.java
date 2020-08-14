package com.example.jwt.demo.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt.demo.annotation.PassToken;
import com.example.jwt.demo.annotation.UserLoginToken;
import com.example.jwt.demo.entity.RespBean;
import com.example.jwt.demo.entity.User;
import com.example.jwt.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        //模拟登录，不从数据库查询用户名密码了，直接使用默认的
        if (user.getUsername().equals("test") && user.getPassword().equals("test")) {
            String token = userService.getToken(user);
            return new RespBean(token, "200");
        } else {
            return new RespBean("用户名不存在或者密码错误", "500");
        }
    }

    @UserLoginToken
    @GetMapping("/test")
    public String getMessage() {
        return "你已登录";
    }
}
