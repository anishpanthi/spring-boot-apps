package com.app.boot.jpa.service;

import com.app.boot.jpa.domain.User;
import com.app.boot.jpa.dto.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Anish
 */
public interface UserService extends BaseService<Long, User>{

    // Any domain specific operation's declaration goes here.

    UserRequest createUser(UserRequest userRequest);

    UserRequest findOneUser(Long id);

    Page<User> findAll(Pageable pageable);

}
