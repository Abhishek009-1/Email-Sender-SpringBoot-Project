package com.abhi.emailsender.Emailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers","entities","services"})
public class EmailserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailserverApplication.class, args);
	}

}
