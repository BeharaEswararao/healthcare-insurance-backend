package com.healthcare.insurance.controller;

import com.healthcare.insurance.model.User;
import com.healthcare.insurance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            User newUser = authService.registerUser(user);
            return "User registered successfully: " + newUser.getUsername();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        try {
            User user = authService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            return "Login successful: " + user.getUsername();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
