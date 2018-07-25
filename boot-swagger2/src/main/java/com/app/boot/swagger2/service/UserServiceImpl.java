package com.app.boot.swagger2.service;

import com.app.boot.swagger2.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anish
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return users.stream().filter(dto -> dto.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void updateUser(User user, Long id) {
        deleteUser(id);
        addUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(getUserById(id));
    }

    @Override
    public void addAll(List<User> users) {
        this.users.addAll(users);
    }
}
