package com.alex.tgbotproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class TgbotProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgbotProjectApplication.class, args);
	}

}
