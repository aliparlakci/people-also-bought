package com.getmidas.peoplealsoboughtpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PeopleAlsoBoughtPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleAlsoBoughtPocApplication.class, args);
	}

}
