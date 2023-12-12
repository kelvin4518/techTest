package com.kz.techtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kz"})
public class TechTest {
    public static void main(String[] args) {
        SpringApplication.run(TechTest.class, args);
    }
}
