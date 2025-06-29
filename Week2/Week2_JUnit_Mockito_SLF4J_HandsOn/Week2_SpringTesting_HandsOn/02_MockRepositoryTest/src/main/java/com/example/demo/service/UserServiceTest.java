package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {
        // 1. Stub the repository
        User mockUser = new User(1L, "Reethika 💖");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // 2. Call the service
        User user = userService.getUserById(1L);

        // 3. Assert the result
        assertNotNull(user);
        assertEquals("Reethika 💖", user.getName());

        // 4. Verify interaction
        verify(userRepository).findById(1L);
    }
}
