package com.victor.apiclientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.apiclientes.entities.Cliente;
import com.victor.apiclientes.repositories.ClienteRepository;

@RestController
@SpringBootApplication
public class ApiClientesApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository rep) {
		return args -> {
			Cliente obj = new Cliente(null, "Victor", "50894664832");
			rep.save(obj);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiClientesApplication.class, args);
	}
	
	@GetMapping
	public String msg() {
		return "API Clientes";
	}

}
