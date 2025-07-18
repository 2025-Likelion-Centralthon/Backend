package com.example.Centralthon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CentralthonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralthonApplication.class, args);
	}

}
