package com.victor.apiclientes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victor.apiclientes.entities.Cliente;
import com.victor.apiclientes.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepo;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente cadastrar(@RequestBody Cliente obj) {
		Cliente newObj = clienteRepo.save(obj);
		return newObj;
	}

}
