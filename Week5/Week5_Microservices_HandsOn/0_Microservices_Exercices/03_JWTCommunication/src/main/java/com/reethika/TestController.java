package com.reethika;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "JWT Communication App is up and running!";
    }

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure JWT-protected endpoint!";
    }
}
