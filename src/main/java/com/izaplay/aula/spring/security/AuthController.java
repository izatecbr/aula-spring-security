package com.izaplay.aula.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private LoginService service;
    @PostMapping("/auth")
    public Session logar(@RequestBody Login login) {
        return service.logar(login);
    }
}
