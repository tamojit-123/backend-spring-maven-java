package com.example.JWTDemo.service;

import com.example.JWTDemo.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
