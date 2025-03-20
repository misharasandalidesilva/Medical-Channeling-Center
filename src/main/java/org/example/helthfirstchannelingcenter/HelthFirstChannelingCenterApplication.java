package org.example.helthfirstchannelingcenter;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelthFirstChannelingCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelthFirstChannelingCenterApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
