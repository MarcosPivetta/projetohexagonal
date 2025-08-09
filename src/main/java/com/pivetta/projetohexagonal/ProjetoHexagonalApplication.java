package com.pivetta.projetohexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoHexagonalApplication.class, args);
	}

}
