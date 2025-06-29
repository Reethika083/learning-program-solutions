package com.example.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    // 🔧 Before each test
    @Before
    public void setUp() {
        System.out.println("Setting up test...");
        userService = new UserService(); // Arrange
    }

    // 🧹 After each test
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...");
        userService = null;
    }

    @Test
    public void testLoginSuccess() {
        // Act
        boolean result = userService.login("admin", "password123");

        // Assert
        assertTrue("Login should succeed for correct credentials", result);
    }

    @Test
    public void testLoginFailure() {
        // Act
        boolean result = userService.login("user", "wrongpass");

        // Assert
        assertFalse("Login should fail for wrong credentials", result);
    }
}
