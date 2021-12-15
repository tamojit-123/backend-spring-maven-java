package com.example.JWTDemo.service;

import com.example.JWTDemo.domain.User;
import com.example.JWTDemo.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException;

    List<User> getAllUser();
}
