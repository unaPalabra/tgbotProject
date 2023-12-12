package com.alex.tgbotproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTgbotProjectApplication {

	public static void main(String[] args) {
		SpringApplication.from(TgbotProjectApplication::main).with(TestTgbotProjectApplication.class).run(args);
	}

}
