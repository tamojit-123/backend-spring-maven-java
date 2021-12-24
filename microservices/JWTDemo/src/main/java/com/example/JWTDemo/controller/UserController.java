package com.example.JWTDemo.controller;

import com.example.JWTDemo.domain.User;
import com.example.JWTDemo.exception.UserNotFoundException;
import com.example.JWTDemo.service.SecurityTokenGenerator;
import com.example.JWTDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private UserService userService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    private ResponseEntity responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return responseEntity = new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/userservice/users")
    public ResponseEntity getAllUser() {
        return responseEntity = new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;
        try {
            User loggedInUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (loggedInUser.getUsername().equals(user.getUsername())) {
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity("try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


}
