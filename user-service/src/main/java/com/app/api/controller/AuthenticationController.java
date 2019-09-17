package com.app.api.controller;

import com.app.api.domain.User;
import com.app.api.dto.LoginRequestDto;
import com.app.api.dto.LoginResponseDto;
import com.app.api.exception.DataException;
import com.app.api.security.dto.JwtUserDto;
import com.app.api.security.util.JwtTokenGenerator;
import com.app.api.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Anish Panthi
 */
@RestController
@Slf4j
@Api(value = "Authentication Controller", tags = "Operations pertaining to User's authentication.")
public class AuthenticationController {

    @Value("${jwt.secret}")
    private String secret;

    private final UserService userService;

    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAuthentication(@RequestBody @Valid LoginRequestDto loginRequestDto, BindingResult result){

        if(result.hasErrors()){
            throw new DataException("Data Validation Error!!!", result);
        }

        User user = userService.findByUsernameAndPassword(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        String token = JwtTokenGenerator.generateToken(new JwtUserDto(user.getId(), user.getUsername(), "ROLE_ADMIN"), secret);

        final LoginResponseDto loginResponseDto = new LoginResponseDto(user.getId(), token, "ROLE_ADMIN");
        loginResponseDto.add(linkTo(methodOn(AuthenticationController.class).getAuthentication(loginRequestDto, result)).withSelfRel());

        return new ResponseEntity<>(loginResponseDto, HttpStatus.ACCEPTED);
    }

    @Autowired
    public AuthenticationController(UserService userService){
        this.userService = userService;
    }
}
