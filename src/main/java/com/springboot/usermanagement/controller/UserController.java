package com.springboot.usermanagement.controller;

import com.springboot.usermanagement.dto.UserDto;
import com.springboot.usermanagement.model.User;
import com.springboot.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // createUser REST API
    // http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // userById REST API
    // http://localhost:8080/api/users/{id}
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // getAllUsers REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    // updateUser REST API
    // http://localhost:8080/api/users/{id}
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // deleteUser REST API
    // http://localhost:8080/api/users/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted.", HttpStatus.OK);
    }
}
