package com.app.boot.swagger2.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.boot.swagger2"})
public class BootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSwagger2Application.class, args);
	}
}
