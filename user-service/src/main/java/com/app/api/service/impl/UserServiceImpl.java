package com.app.api.service.impl;

import com.app.api.domain.User;
import com.app.api.dto.UserDto;
import com.app.api.exception.ApiException;
import com.app.api.exception.DataAlreadyExistsException;
import com.app.api.exception.NotFoundException;
import com.app.api.repository.UserRepository;
import com.app.api.service.UserService;
import com.app.api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Anish Panthi
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() throws ApiException {
        List<User> usersInDb;
        try {
            usersInDb = userRepository.findAll();
            if (usersInDb.isEmpty()) {
                throw new NotFoundException("Record Not Found!!!");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }

        List<UserDto> userDtoList = new ArrayList<>();

        usersInDb.forEach(user -> {
                    UserDto userDto = new UserDto();
                    BeanUtils.copyProperties(user, userDto);
                    userDtoList.add(userDto);
                }
        );
        return userDtoList;
    }

    @Override
    public UserDto findOne(Long id) throws ApiException {
        UserDto userDto = new UserDto();
        try {
            Optional<User> user = userRepository.findById(id);
            if (!user.isPresent()) {
                throw new NotFoundException("Record Not Found By Given Id!!!");
            }
            BeanUtils.copyProperties(user.get(), userDto);
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
        return userDto;
    }

    @Override
    public Object save(UserDto userDto) throws ApiException {
        try {
            User userInDb = userRepository.findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
            if (userInDb != null) {
                throw new DataAlreadyExistsException(userDto.getUsername() + "/" + userDto.getEmail() + " already exists!!!");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
        return saveOrUpdate(userDto, Constants.SAVE);
    }

    @Override
    public Object update(UserDto userDto) throws ApiException {
        try {
            Optional<User> userInDb = userRepository.findById(userDto.getId());
            if (!userInDb.isPresent()) {
                throw new DataAlreadyExistsException("Unable to find " + userDto.getId() + " to update. User doesn't exists!!!");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
        return saveOrUpdate(userDto, Constants.UPDATE);
    }

    @Override
    public Object delete(UserDto userDto) throws ApiException {
        try {
            Optional<User> userInDb = userRepository.findById(userDto.getId());
            if (!userInDb.isPresent()) {
                throw new DataAlreadyExistsException("Unable to find " + userDto.getId() + " to delete. User doesn't exists!!!");
            }
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userRepository.delete(user);
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
        return prepareSuccessCrudStatusDto(Constants.DELETE);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> userOptional = Optional.empty();
        try {
            userOptional = userRepository.findByUsername(username);
        } catch (Exception e) {
            log.error("", e);
        }
        return userOptional;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User userInDb;
        try {
            userInDb = userRepository.findByUsernameAndPassword(username, password);
            if (userInDb == null) {
                throw new NotFoundException("Username or Password mismatched!!!");
            }
        } catch (Exception e) {
            log.error("", e);
            throw new ApiException(e.getMessage());
        }
        return userInDb;
    }

    @Override
    public Page<UserDto> findAllByPage(Pageable pageable) {
        return null;
    }

    private Object saveOrUpdate(UserDto userDto, String operation) throws ApiException {
        try {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userRepository.save(user);
        } catch (Exception e) {
            log.error("", e);
            throwCrudError(operation);
        }
        return prepareSuccessCrudStatusDto(operation);
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
