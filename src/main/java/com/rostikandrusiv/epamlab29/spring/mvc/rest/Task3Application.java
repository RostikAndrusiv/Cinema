package com.rostikandrusiv.epamlab29.spring.mvc.rest;

import org.modelmapper.ModelMapper;

import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task3Application {


    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration()
////                .setMatchingStrategy(MatchingStrategies.STRICT)
//                .setFieldMatchingEnabled(true)
//                .setSkipNullEnabled(true)
//                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
//        return mapper;
   // }
}
