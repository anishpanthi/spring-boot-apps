package com.app.boot.swagger2.service;

import com.app.boot.swagger2.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUserById(Long id);

    User addUser(User user);

    void updateUser(User user, Long id);

    void deleteUser(Long id);

    void addAll(List<User> users);
}
