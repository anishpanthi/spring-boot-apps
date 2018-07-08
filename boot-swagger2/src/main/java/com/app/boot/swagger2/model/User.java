package com.app.boot.swagger2.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(notes = "User's First Name", position = 0)
    private String firstName;

    @ApiModelProperty(notes = "User's Last Name", position = 1)
    private String lastName;

    @ApiModelProperty(notes = "User's Email address.", position = 2)
    private String email;

    @ApiModelProperty(notes = "User's Phone number", position = 3)
    private String phone;

}
