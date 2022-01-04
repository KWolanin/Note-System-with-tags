package com.wolanin.watchos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.wolanin.watchos"})
@Configuration
public class WatchosApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchosApplication.class, args);
    }

}