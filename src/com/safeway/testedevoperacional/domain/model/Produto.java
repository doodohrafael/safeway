package com.safeway.testedevoperacional.domain.model;

public class Produto {

	private Integer id;
	private String nome;
	private Integer quantidade;
	private Double preco;
	private Empresa empresa;

	public Produto(Integer id, String nome, Integer quantidade, Double preco, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.empresa = empresa;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

}
