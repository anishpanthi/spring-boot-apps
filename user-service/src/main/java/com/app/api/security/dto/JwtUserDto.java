package com.app.api.security.dto;

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
public class JwtUserDto implements Serializable {

    private Long id;

    private String username;

    private String role;
}
