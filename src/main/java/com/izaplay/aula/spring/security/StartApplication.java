package com.izaplay.aula.spring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Gerando senha criptografada: ");
        //System.out.println(passwordEncoder.encode("user123"));
        //System.out.println(passwordEncoder.encode("master123"));

    }
}
