package com.izaplay.aula.spring.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final String SECRET = "rbm9Ej/jm2Fga08/OR8TDrg4jzvnx6YPDmMjlyMaftWHyOVrwK+/0NNuU8hiUvJPWetmKkzsYWZHO6rUAS8yFA==";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());

    private final long EXPIRATION = 1000 * 60 * 60; // 1 hora

    public String generateToken(UserEntity user) {

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", user.getRoles()) // 👈 adicionando roles
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public List<String> extractRoles(String token) {
        return extractAllClaims(token).get("roles", List.class);
    }

    public boolean isTokenValid(String token, UserEntity user) {
        final String username = extractUsername(token);
        return username.equals(user.getUsername()) &&
                !extractAllClaims(token).getExpiration().before(new Date());
    }
}