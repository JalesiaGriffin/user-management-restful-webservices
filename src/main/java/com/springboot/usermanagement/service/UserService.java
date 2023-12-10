package com.springboot.usermanagement.service;

import com.springboot.usermanagement.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(long userId);

    List<User> getAllUsers();

    User updateUser(User user);
}
