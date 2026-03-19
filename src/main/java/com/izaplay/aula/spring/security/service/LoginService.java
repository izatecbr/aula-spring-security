package com.izaplay.aula.spring.security.service;

import com.izaplay.aula.spring.security.config.JwtService;
import com.izaplay.aula.spring.security.dto.Login;
import com.izaplay.aula.spring.security.dto.Session;
import com.izaplay.aula.spring.security.model.UserEntity;
import com.izaplay.aula.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtService jwtService;
    public Session logar(Login login) {
        UserEntity user = repository.findByUsername(login.getUsername());
        if (user != null && encoder.matches(login.getPassword(), user.getPassword())) {
            Session session = new Session();
            session.setUsername(user.getUsername());
            String token = jwtService.generateToken(user);
            session.setToken(token);
            return session;
        }
        return null;
    }
}