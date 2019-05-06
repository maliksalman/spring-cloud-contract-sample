package com.smalik.invoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InvokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvokerApplication.class, args);
	}

}
