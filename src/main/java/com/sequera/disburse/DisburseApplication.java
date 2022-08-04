package com.sequera.disburse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DisburseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisburseApplication.class, args);
	}

}
