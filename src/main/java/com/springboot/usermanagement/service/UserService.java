package com.springboot.usermanagement.service;

import com.springboot.usermanagement.model.User;

public interface UserService {
    User createUser(User user);

    User getUserById(long userId);
}
