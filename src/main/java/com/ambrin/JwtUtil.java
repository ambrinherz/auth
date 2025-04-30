package com.ambrin;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRETKEY = "your-256-bit-secret-your-256-bit-secret";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRETKEY.getBytes());
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("your-256-bit-secret-your-256-bit-secret".getBytes(StandardCharsets.UTF_8));



    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public List<GrantedAuthority> extractRoles(String token) {
        List<String> roles = (List<String>) Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("roles", List.class);  // safer casting

        System.out.println("Roles extracted: " + roles);

        return roles.stream()
                .map(SimpleGrantedAuthority::new)  // more concise
                .collect(Collectors.toList());
    }


    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}