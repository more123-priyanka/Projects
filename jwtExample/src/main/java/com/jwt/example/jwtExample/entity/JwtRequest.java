package com.jwt.example.jwtExample.entity;


public class JwtRequest {
    
    private String username;
    private String password;

    // No-args constructor
    public JwtRequest() {
    }

    // All-args constructor
    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for email
    public String getEmail() {
        return username;
    }

    // Setter for email
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

 
    @Override
    public String toString() {
        return "JwtRequest{" +
                "email='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}