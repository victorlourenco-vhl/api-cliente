package com.victor.apiclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiClientesApplication {

//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository rep) {
//		return args -> {
//			Cliente obj = new Cliente(null, "Victor", "43233656084");
//			rep.save(obj);
//			
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ApiClientesApplication.class, args);
	}

	@GetMapping
	public String msg() {
		return "API Clientes";
	}

}
