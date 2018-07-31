package com.app.boot.swagger2.api;

import com.app.boot.swagger2.domain.User;
import com.app.boot.swagger2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.boot.swagger2"})
@Slf4j
public class BootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSwagger2Application.class, args);
	}

	@Bean
	CommandLineRunner prepareData(UserService userService){
		return args-> {
            List<User> users = new ArrayList<>();

            //Create Users and add it to List
            users.add(new User(1L, "John","Washington","john.washington@gmail.com","469-111-1111"));
            users.add(new User(2L, "Alan", "Smith", "alan.smith@gmail.com", "469-222-2222"));
            users.add(new User(3L, "Anish", "Panthi", "anish.panthi@gmail.com", "469-333-3333"));

            userService.addAll(users);
            log.info("3 Users Added Successfully.");
        };
	}
}
