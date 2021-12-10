package com.stackroute.springBootDemoOne.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String sayHello() {
        return "HelloWorld";
    }
}
