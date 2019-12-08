package com.integrant.amazonws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.integrant")
public class AmazonwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonwsApplication.class, args);
    }

}
