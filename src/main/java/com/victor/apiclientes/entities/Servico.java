package com.victor.apiclientes.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Servico implements Serializable {

	private final static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Length(min = 10, max = 150, message = "A descrição deve ter entre 10 e 150 caracteres")
	private String descricao;
	
	@NotNull(message = "O valor do serviço deve ser preenchido")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	public Servico() {
		
	}
	
	

}
