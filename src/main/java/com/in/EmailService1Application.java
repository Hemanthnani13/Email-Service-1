package com.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailService1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmailService1Application.class, args);
	}

}
