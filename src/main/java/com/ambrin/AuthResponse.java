package com.ambrin;

public class AuthResponse {
    private String accessToken;
    private String refreshToken;

    public AuthResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    // Getters & setters
    public String getAccessToken() {
        return accessToken;
    }

    // Setter for username
    public void setAccessToken(String username) {
        this.accessToken = accessToken;
    }

    // Getter for password
    public String getRefreshToken() {
        return refreshToken;
    }

    // Setter for password
    public void setPassword(String password) {
        this.refreshToken = refreshToken;
    }
}


