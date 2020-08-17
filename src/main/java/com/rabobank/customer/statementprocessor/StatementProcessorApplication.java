package com.rabobank.customer.statementprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatementProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatementProcessorApplication.class, args);
	}

<<<<<<< HEAD
=======
	@SuppressWarnings("deprecation")
	@Bean public WebMvcConfigurer corsConfigurer() { return new
	  WebMvcConfigurerAdapter() {
	  
	  @Override public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("**/**").allowedOrigins(
	  "https://rbuistatement.herokuapp.com"); } }; }
	
>>>>>>> 21877890d1ebaa5c9b21afe3b646dfc959f55912
}
