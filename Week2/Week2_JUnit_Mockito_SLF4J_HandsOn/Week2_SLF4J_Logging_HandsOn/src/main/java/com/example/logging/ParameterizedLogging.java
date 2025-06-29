package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Reethika";
        int score = 95;

        logger.info("User {} scored {} marks", user, score);
    }
}
