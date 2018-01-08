package com.app.usermanagement.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 * <p>
 * 1/8/2018
 */
@RestController
@RequestMapping("/v1")
public class HomeController {

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
