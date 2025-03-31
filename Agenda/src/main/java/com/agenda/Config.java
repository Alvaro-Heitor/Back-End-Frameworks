package com.agenda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public BancoDeDados bancoDeDados(){
        return new BancoDeDados();
    }
}