package com.example.jwt.util;

import java.util.Base64;

public class BasicAuthDecoder {

    public static String[] decode(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new IllegalArgumentException("Invalid Authorization header.");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decoded = new String(decodedBytes);
        return decoded.split(":", 2); // returns [username, password]
    }
}
