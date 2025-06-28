package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        // Normally fetch from repo, here just dummy
        return new User(id, "RealUser");
    }
}
