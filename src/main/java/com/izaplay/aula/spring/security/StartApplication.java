package com.izaplay.aula.spring.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Transactional
    @Override
    public void run(String... args) throws Exception {

    }
}