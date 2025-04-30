package com.ambrin.Dto;

public class RegisterRequest {
    private String username;
    private String password;

    private String role;

    public String getUsername(){
        return username;
    }

    public String getRole(){
        return role;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

