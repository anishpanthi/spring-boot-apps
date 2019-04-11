package com.app.boot.jpa.controller;

import com.app.boot.jpa.domain.User;
import com.app.boot.jpa.dto.ApiPageable;
import com.app.boot.jpa.dto.UserRequest;
import com.app.boot.jpa.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Anish
 */
@RestController
@RequestMapping("/1.0")
@Api(value = "User Controller", description = "Operations pertaining to Users.")
public class UserController {

    private final UserService userService;

    /**
     *
     * @param userService
     */
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     *
     * @return
     */
    @ApiPageable
    @ApiOperation(value = "Returns all list of users.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {

        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Returns User if ID is found.", response = User.class)
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserRequest> getUserById(@PathVariable("id")
                                            @ApiParam(value = "User ID", required = true) Long id) {

        return new ResponseEntity<>(userService.findOneUser(id), HttpStatus.OK);
    }

    /**
     *
     * @param userRequest
     * @return
     */
    @ApiOperation(value = "Stores the user.", response = User.class)
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserRequest> saveUser(
            @ApiParam(value = "User details", required = true) @RequestBody UserRequest userRequest) {

        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    /**
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "Updates the user based Id.")
    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateUser(
            @ApiParam(value = "User details", required = true) @RequestBody User user){

        //Long id = user.getId();
        userService.update(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Deletes the user based on given Id.")
    @DeleteMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "User ID", required = true) @PathVariable("id") Long id){

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
