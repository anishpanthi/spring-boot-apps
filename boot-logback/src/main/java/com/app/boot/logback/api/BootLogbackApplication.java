package com.app.boot.logback.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLogbackApplication.class, args);

        log.debug("Hello, I'm DEBUG message.");
        log.info("Hello, I'm INFO message.");
        log.warn("Hello, I'm WARN message.");
        log.error("Hello, I'm ERROR message.");
    }
}
