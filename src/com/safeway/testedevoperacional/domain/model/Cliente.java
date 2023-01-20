package com.safeway.testedevoperacional.domain.model;

public class Cliente {

	private String cpf;
	private String nome;
	private String username;
	private Integer idade;
	
	public Cliente(String cpf, String nome, String username, Integer idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.username = username;
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsername() {
		return username;
	}

}