package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.NoSuchElementException;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testGetUserByIdThrowsException() {
        // 1. Stub empty result
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // 2. Assert that exception is thrown
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(99L);
        });

        // 3. Check message (optional)
        assertTrue(exception.getMessage().contains("User not found"));
    }
}
