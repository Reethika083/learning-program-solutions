package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAndFetchUser() {
        String baseUrl = "http://localhost:" + port + "/users";

        // POST
        User createdUser = restTemplate.postForObject(baseUrl, new User("Reethika 💖"), User.class);
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("Reethika 💖", createdUser.getName());

        // GET
        User fetchedUser = restTemplate.getForObject(baseUrl + "/" + createdUser.getId(), User.class);
        assertEquals("Reethika 💖", fetchedUser.getName());
    }
}
