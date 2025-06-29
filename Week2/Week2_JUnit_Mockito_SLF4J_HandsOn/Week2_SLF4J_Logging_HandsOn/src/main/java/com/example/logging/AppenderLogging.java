package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.info("Application started");
        logger.warn("Low disk space");
        logger.error("Unhandled exception occurred");
    }
}
