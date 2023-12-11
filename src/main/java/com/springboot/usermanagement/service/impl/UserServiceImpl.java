package com.springboot.usermanagement.service.impl;

import com.springboot.usermanagement.dto.UserDto;
import com.springboot.usermanagement.exception.EmailAlreadyExistsException;
import com.springboot.usermanagement.exception.ResourceNotFoundException;
import com.springboot.usermanagement.model.User;
import com.springboot.usermanagement.repository.UserRepository;
import com.springboot.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // convert UserDto into User JPA Entity
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        //convert User JPA entity to UserDto
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() ->
                                            new ResourceNotFoundException("User", "id", user.getId()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}
