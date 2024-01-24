package com.symbiosis.productManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan({"com.symbiosis.productManagementSystem","com.symbiosis.controller","com.symbiosis.dao","com.symbiosis.model","com.symbiosis.service"})
@EntityScan("com.symbiosis.model")
@EnableJpaRepositories(basePackages="com.symbiosis.dao")
public class ProductManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementSystemApplication.class, args);
	}

}
