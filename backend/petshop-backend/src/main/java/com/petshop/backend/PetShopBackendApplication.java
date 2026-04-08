package com.petshop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.petshop.catalog.controller",
        "com.petshop.catalog.service",
        "com.petshop.catalog.repository",
        "com.petshop.catalog.mapper",
        "com.petshop.catalog.exception",
        "com.petshop.catalog.entity",
        "com.petshop.commerce.controller",
        "com.petshop.commerce.service",
        "com.petshop.commerce.repository",
        "com.petshop.commerce.mapper",
        "com.petshop.commerce.exception",
        "com.petshop.commerce.entity",
        "com.petshop.shared"
})
public class PetShopBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetShopBackendApplication.class, args);
    }
}
