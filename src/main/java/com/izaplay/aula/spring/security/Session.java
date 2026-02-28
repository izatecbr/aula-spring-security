package com.izaplay.aula.spring.security;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Session {
    private String token;
    private String username;
    private LocalDateTime expiration;
}
