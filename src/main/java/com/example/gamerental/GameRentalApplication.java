package com.example.gamerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GameRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameRentalApplication.class, args);
    }

}
