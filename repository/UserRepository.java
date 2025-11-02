package com.healthcare.insurance.repository;

import com.healthcare.insurance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository interface for database operations on User entities
// Extends JpaRepository which provides basic CRUD operations
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Custom method to find a user by username
    // Used during login to find user by username
    User findByUsername(String username);
    
    // Custom method to find a user by email
    // Used to check if email is already registered
    User findByEmail(String email);
}