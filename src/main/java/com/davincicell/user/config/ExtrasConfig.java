package com.davincicell.user.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtrasConfig {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
