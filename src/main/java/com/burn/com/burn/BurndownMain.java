package com.burn.com.burn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.burn.*")
@EntityScan("com.burn.*")
@EnableAutoConfiguration
public class BurndownMain {
    public static void main(String[] args) {
        System.out.println("===Welcome to Project BurnDOwn===");
        ApplicationContext context = SpringApplication.run(BurndownMain.class, args);

    }
}
