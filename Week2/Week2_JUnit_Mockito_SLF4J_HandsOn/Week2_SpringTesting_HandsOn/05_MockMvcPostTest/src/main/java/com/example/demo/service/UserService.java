package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User saveUser(User user) {
        user.setId(1L); // Fake saved user with ID
        return user;
    }
}
