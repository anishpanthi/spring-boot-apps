package com.app.boot.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Anish
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable {

    @ApiModelProperty(notes = "User's First Name")
    private String firstName;

    @ApiModelProperty(notes = "User's Last Name", position = 1)
    private String lastName;

    @ApiModelProperty(notes = "User's Email address.", position = 2)
    private String email;

    @ApiModelProperty(notes = "User's Phone number", position = 5)
    private String phone;

    @ApiModelProperty(notes = "User's Login UserName", position = 3)
    private String username;

    @ApiModelProperty(notes = "User's Password.", position = 4, hidden = true)
    @JsonIgnore
    private String password;
}
