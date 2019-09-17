package com.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * @author Anish Panthi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends ResourceSupport {

    private List<UserDto> userDtoList;
}
