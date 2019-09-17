package com.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author Anish Panthi
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto extends ResourceSupport {

    private Long userId;

    private String token;

    private String role;
}
