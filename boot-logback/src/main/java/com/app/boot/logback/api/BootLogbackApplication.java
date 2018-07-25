package com.app.boot.logback.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLogbackApplication.class, args);

        log.debug("This is debug log.");
        log.info("This is info log.");
        log.warn("This is warn log.");
        log.error("This is error log.");
    }
}
