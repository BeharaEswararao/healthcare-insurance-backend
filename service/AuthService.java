package com.healthcare.insurance.service;

import com.healthcare.insurance.model.User;
import com.healthcare.insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service class for handling user authentication operations
// Contains business logic for user registration and login
@Service
public class AuthService {
    
    // Dependency injection of UserRepository
    @Autowired
    private UserRepository userRepository;
    
    // Method to register a new user
    public User registerUser(User user) {
        // Check if username already exists in database
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("Username already exists");
        }
        
        // Set default role to PATIENT if no role is provided
        if (user.getRole() == null) {
            user.setRole("PATIENT");
        }
        
        // Save the new user to database and return the saved user
        return userRepository.save(user);
    }
    
    // Method to authenticate user during login
    public User loginUser(String username, String password) {
        // Find user by username in database
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        
        // Simple password check (for learning purposes)
        // In real applications, use password encryption
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        
        // Return user if authentication is successful
        return user;
    }
}
