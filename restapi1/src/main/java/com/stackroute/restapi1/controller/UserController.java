package com.stackroute.restapi1.controller;

import com.stackroute.restapi1.model.User;
import com.stackroute.restapi1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController is responsible for returning the data  by directly writing into HTTP response as JSON
@RestController
@RequestMapping("/api/v1/user")
//@RestController is a combination of @Controller and @ResponseBody
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ResponseEntity object is returned from the handler  method of the controller
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}