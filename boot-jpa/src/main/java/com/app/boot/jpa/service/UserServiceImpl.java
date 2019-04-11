package com.app.boot.jpa.service;

import com.app.boot.jpa.dao.UserDao;
import com.app.boot.jpa.domain.User;
import com.app.boot.jpa.dto.ApiPageable;
import com.app.boot.jpa.dto.UserRequest;
import com.app.boot.jpa.util.PasswordGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findOne(Long aLong) {
        return this.userDao.findById(aLong);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User create(User user) {
        return this.userDao.save(user);
    }

    @Override
    public void delete(Long aLong) {
        this.userDao.deleteById(aLong);
    }

    @Override
    public User update(User user) {
        return this.userDao.save(user);
    }

    @Override
    public UserRequest createUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setPassword(String.valueOf(PasswordGenerator.generatePassword()));
        create(user);
        return userRequest;
    }

    @Override
    public UserRequest findOneUser(Long id) {
        UserRequest userResponse = new UserRequest();
        return findOne(id).map(u -> {
            BeanUtils.copyProperties(u, userResponse);
            return userResponse;
        }).orElseThrow(() -> new RuntimeException("User Not Found."));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        log.info("Page Number:: {}", pageable.getPageNumber());
        log.info("Page Size:: {}", pageable.getPageSize());
        return this.userDao.findAll(findPages(pageable));
    }

    private PageRequest findPages(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
    }
}
