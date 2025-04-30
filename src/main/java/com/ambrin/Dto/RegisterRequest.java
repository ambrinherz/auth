package com.ambrin.Dto;

import java.util.List;

public class RegisterRequest {
    private String username;
    private String password;

    private List<String> roles;

    public String getUsername(){
        return username;
    }

    public List<String> getRoles(){
        return roles;
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

    public void setRole(List<String> role) {
        roles.addAll(role);
    }
}

