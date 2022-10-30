package com.observationclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
public class ObservationClassApplication {
    public static void main(String[] args) {
        SpringApplication.run(ObservationClassApplication.class, args);
    }
}
