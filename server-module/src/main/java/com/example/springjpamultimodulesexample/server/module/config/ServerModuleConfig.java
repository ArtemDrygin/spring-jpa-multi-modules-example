package com.example.springjpamultimodulesexample.server.module.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerModuleConfig {
    @Bean(name = "serverCommandLineRunner")
    public CommandLineRunner commandLineRunner() {
        return (a) -> System.out.println("run server module config");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
