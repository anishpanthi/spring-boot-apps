package com.app.boot.jpa.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Anish
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @ApiModelProperty(notes = "User's ID") // We don't need to define position here. Default position is 0
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    @ApiModelProperty(notes = "User's First Name", position = 1)
    @NotBlank
    @Size(min = 1, max = 20)
    private String firstName;

    @Column(name = "LAST_NAME")
    @ApiModelProperty(notes = "User's Last Name", position = 2)
    @NotBlank
    @Size(min = 1, max = 20)
    private String lastName;

    @Column(name = "EMAIL")
    @ApiModelProperty(notes = "User's Email address.", position = 3)
    @Email
    private String email;

    @Column(name = "PHONE")
    @ApiModelProperty(notes = "User's Phone number", position = 4)
    @Size(max = 12)
    private String phone;

    @Column(name = "USERNAME")
    @ApiModelProperty(notes = "User's Login UserName", position = 5)
    @Size(min = 8, max = 20)
    private String username;

    @Column(name = "PASSWORD")
    @ApiModelProperty(notes = "User's Encrypted Password.", position = 6)
    @Size(min = 8, max = 64)
    private String password;

}
