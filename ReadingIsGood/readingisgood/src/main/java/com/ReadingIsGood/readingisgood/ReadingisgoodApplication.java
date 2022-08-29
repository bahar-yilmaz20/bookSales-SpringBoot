package com.ReadingIsGood.readingisgood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ReadingisgoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingisgoodApplication.class, args);
	}

}
