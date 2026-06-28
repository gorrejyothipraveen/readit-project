package com.tw.readit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReaditApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReaditApplication.class, args);
	}
}