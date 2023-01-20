package com.safeway.testedevoperacional.domain.model;


public class Usuario {
	
	private String username;
	private String senha;
	private Empresa empresa;

	public Usuario(String username, String senha, Cliente cliente, Empresa empresa) {
		this.username = username;
		this.senha = senha;
		this.empresa = empresa;
	}
	
	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
	}
	
	public Usuario(String username, String senha, Cliente cliente) {
		this.username = username;
		this.senha = senha;
	}
	
	public Usuario(String username, String senha, Empresa empresa) {
		this.username = username;
		this.senha = senha;
		this.empresa = empresa;
	}

	public boolean IsEmpresa() {
		return this.empresa != null;
	}

	public String getUsername() {
		return username;
	}

	public String getSenha() {
		return senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}


}
