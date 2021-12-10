package com.stackroute.restapi1.service;

import com.stackroute.restapi1.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();
}