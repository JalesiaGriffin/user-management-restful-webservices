package com.springboot.usermanagement.service;

import com.springboot.usermanagement.dto.UserDto;
import com.springboot.usermanagement.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(long userId);

    List<UserDto> getAllUsers();

    User updateUser(User user);

    void deleteUser(long userId);
}
