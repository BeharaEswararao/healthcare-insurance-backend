package com.healthcare.insurance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    // Primary key - auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // User authentication fields
    private String username;
    private String password;
    private String email;
    private String role;
    
    // Default Constructor (required by JPA)
    public User() {
    }
    
    // Parameterized constructor (for easy object creation)
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // GETTER METHODS

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // SETTER METHODS

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
