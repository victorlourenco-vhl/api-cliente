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

	public Servico(Integer id, String descricao, BigDecimal valor, Cliente cliente) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
