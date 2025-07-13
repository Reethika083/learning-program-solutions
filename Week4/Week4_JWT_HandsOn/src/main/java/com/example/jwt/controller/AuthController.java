package com.example.jwt.controller;

import com.example.jwt.model.AuthResponse;
import com.example.jwt.service.JwtService;
import com.example.jwt.util.BasicAuthDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String[] credentials = BasicAuthDecoder.decode(authHeader);
        String username = credentials[0];
        String password = credentials[1];

        // Simple check (in real-world: validate with DB)
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = jwtService.generateToken(username);
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
