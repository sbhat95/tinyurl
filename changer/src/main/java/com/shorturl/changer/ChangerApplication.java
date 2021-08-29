package com.shorturl.changer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.shorturl.changer.controller.URLChangeController;

@SpringBootApplication
@ComponentScan(basePackages="com.shorturl.changer")
public class ChangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangerApplication.class, args);
	}

}
