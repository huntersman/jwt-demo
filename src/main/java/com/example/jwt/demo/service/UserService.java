package com.example.jwt.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public User findUserById(String username) {
        User user = new User();
        if (username.equals("test")) {
            user.setUsername("test");
            user.setPassword("test");
        }
        return user;
    }
}
