package com.victor.apiclientes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente acharPorId(@PathVariable Integer id) {
		return clienteRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		clienteRepo
			.findById(id)
			.map(cliente -> {
				clienteRepo.delete(cliente);
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody Cliente obj) {
		clienteRepo
		.findById(id)
		.map(cliente -> {
			obj.setId(cliente.getId());
			clienteRepo.save(obj);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
