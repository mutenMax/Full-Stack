package com.infinity.application;

import com.infinity.application.entities.CreditCard;
import com.infinity.application.repositories.CreditCardRepository;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	@Profile("!test")
	CommandLineRunner init(CreditCardRepository creditCardRepository) {
		return args -> {
			Stream.of("Alice", "Bob").forEach(Name -> {
				CreditCard creditCard = new CreditCard(Name, "1111222233334444", new BigDecimal(100), new BigDecimal("1000"));
				creditCardRepository.save(creditCard);
			});
			creditCardRepository.findAll().forEach(System.out::println);
		};
	}
}
