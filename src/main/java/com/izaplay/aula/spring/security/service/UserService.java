package com.izaplay.aula.spring.security.service;

import com.izaplay.aula.spring.security.model.UserEntity;
import com.izaplay.aula.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    /*
        Este método tem como objetivo demontrar como salvar uma usuário com senha criptografada utilizando
        o encriptador do Spring
     */
    public void createUser(){//Coloque o seu DTO e Crie o Seu Controller ou WebService
        UserEntity newUser = new UserEntity();
        newUser.setName("Gleyson Sampaio");
        newUser.setUsername("glysns");
        newUser.setRoles(List.of("ROLE_USERS","ROLE_MANAGERS"));

        String senhaCriptografada = encoder.encode("SENHA_DO_USUARIO_SENHA_TEMPORARIA");
        newUser.setPassword(senhaCriptografada);

        repository.save(newUser);
    }
}
