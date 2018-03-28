package com.app.boot.swagger2.controller;

import com.app.boot.swagger2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1.0")
public class HomeController {

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getHome(){

//        String[] array = {"a","b","c","d","e"};
//        List<String> streamList = Arrays.stream(array)
//                .filter(x -> x.equalsIgnoreCase("a"))
//                .map(x->x.toUpperCase())
//                .collect(Collectors.toList());

        return new ResponseEntity<>(new User("Anish","Panthi","anish.panthi@gmail.com","1234567890"), HttpStatus.OK);
    }
}
