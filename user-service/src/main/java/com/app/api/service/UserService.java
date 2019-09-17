package com.app.api.service;

import com.app.api.domain.User;
import com.app.api.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Anish Panthi
 */
public interface UserService extends BaseService<User, UserDto, Long> {

    User findByUsernameAndPassword(String username, String password);

    Page<UserDto> findAllByPage(Pageable pageable);
}
