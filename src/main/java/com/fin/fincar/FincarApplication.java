package com.fin.fincar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.fin.fincar.model.Car")
@SpringBootApplication(scanBasePackages = {"com.fin.fincar.model.*"})
public class FincarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FincarApplication.class, args);
	}
}
