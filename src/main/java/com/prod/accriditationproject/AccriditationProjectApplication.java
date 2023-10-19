package com.prod.accriditationproject;

import com.prod.accriditationproject.configuration.RsaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaProperties.class)
public class AccriditationProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccriditationProjectApplication.class, args);
    }

}
