package com.safeway.testedevoperacional.domain.model;

import java.util.List;

public class Venda {
	
	private Integer codigo;
	private List<Produto> itens;
	private Double valor;
	private Double comissao;
	private Empresa empresa;
	private Cliente cliente;

	public Venda(Integer codigo, List<Produto> itens, Double valor, 
				 Double comissao, Empresa empresa, Cliente cliente) {
		this.codigo = codigo;
		this.itens = itens;
		this.valor = valor;
		this.comissao = comissao;
		this.empresa = empresa;
		this.cliente = cliente;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public Double getValor() {
		return valor;
	}

	public Double getComissao() {
		return comissao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
