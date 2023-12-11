package com.springboot.usermanagement.mapper;

import com.springboot.usermanagement.dto.UserDto;
import com.springboot.usermanagement.model.User;

public class UserMapper {
    // Converts User JPA Entity into UserDto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDto;
    }

    // Converts User JPA Entity into UserDto
    public static User mapToUser(UserDto userDto){
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return user;
    }
}
