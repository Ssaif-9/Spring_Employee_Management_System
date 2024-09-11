package com.ebi.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeans {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
