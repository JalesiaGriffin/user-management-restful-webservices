package com.springboot.usermanagement.service;

import com.springboot.usermanagement.dto.UserDto;
import com.springboot.usermanagement.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    User getUserById(long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(long userId);
}
