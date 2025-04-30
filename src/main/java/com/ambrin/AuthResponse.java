package com.ambrin;

public class AuthResponse {
    private String accessToken;
    private String refreshToken;

    public AuthResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String username) {
        this.accessToken = accessToken;
    }


    public String getRefreshToken() {
        return refreshToken;
    }


    public void setPassword(String password) {
        this.refreshToken = refreshToken;
    }
}


