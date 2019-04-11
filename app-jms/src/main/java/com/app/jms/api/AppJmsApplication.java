package com.app.jms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(scanBasePackages = {"com.app.jms.api"})
@EnableJms
public class AppJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppJmsApplication.class, args);
    }
}
