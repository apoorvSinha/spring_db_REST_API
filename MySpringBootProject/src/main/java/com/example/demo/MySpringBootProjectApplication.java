package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootProjectApplication.class, args);
		
		/*
		 * netstat -ano | findstr :8080
		 * taskkill /F /PID 12017
		 * */
		
	}

}
