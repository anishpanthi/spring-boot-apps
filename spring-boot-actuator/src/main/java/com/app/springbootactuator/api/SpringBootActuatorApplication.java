package com.app.springbootactuator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuatorApplication.class, args);
	}
}
