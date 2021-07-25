package com.stockmanagementsystem.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockmanagementsystemserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockmanagementsystemserverApplication.class, args);
    }

}
