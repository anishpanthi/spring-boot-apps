package com.app.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    @ApiModelProperty(notes = "User's ID")
    private Long id;

    @ApiModelProperty(notes = "First Name", position = 1)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", position = 2)
    private String lastName;

    @ApiModelProperty(notes = "Unique Email Address", position = 3)
    private String email;

    @ApiModelProperty(notes = "Mobile Number", position = 4)
    private String contact;

    @ApiModelProperty(notes = "Unique Username", position = 5)
    private String username;

    @JsonIgnore
    @ApiModelProperty(notes = "User Password", position = 6)
    private String password;
}
