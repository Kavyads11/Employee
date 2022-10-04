package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
		"com.example.demo"})
@EnableJpaRepositories
public class EmployeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeManagementApplication.class, args);
	}

}
