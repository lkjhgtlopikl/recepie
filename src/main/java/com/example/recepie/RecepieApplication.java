package com.example.recepie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.recepie.model")
public class RecepieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecepieApplication.class, args);
	}

}
