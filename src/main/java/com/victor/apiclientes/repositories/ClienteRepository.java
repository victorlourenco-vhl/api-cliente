package com.victor.apiclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.apiclientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
