package com.coffeeshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeShopApplication {
    private static final Logger LOG = LoggerFactory.getLogger(CoffeeShopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }
}
