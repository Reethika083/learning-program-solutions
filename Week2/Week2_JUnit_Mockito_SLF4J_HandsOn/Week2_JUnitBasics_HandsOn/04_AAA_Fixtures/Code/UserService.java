package com.example.junit;

public class UserService {

    public boolean login(String username, String password) {
        return "admin".equals(username) && "password123".equals(password);
    }
}
