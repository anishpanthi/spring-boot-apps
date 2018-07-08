package com.app.boot.swagger2.controller;

import com.app.boot.swagger2.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1.0")
@Api(value = "Home Controller", description = "Operations pertaining to Users.")
public class HomeController {

    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getHome() {

//        String[] array = {"a","b","c","d","e"};
//        List<String> streamList = Arrays.stream(array)
//                .filter(x -> x.equalsIgnoreCase("a"))
//                .map(x->x.toUpperCase())
//                .collect(Collectors.toList());

        return new ResponseEntity<>(new User("Anish", "Panthi", "anish.panthi@gmail.com", "1234567890"), HttpStatus.OK);
    }

    @ApiOperation(value = "List User based on first name provided.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/user/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUserDetails(@PathVariable("firstName")
                                               @ApiParam(value = "First Name", required = true) String firstName) {

        return new ResponseEntity<>(new User(firstName, "ABC", "abc@gmail.com", "1239875678"), HttpStatus.OK);
    }
}