package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        // 1. Save sample users
        userRepository.save(new User("Reethika"));
        userRepository.save(new User("Reethika"));
        userRepository.save(new User("Another"));

        // 2. Query by name
        List<User> result = userRepository.findByName("Reethika");

        // 3. Assertions
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(u -> u.getName().equals("Reethika")));
    }
}
