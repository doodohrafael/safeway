package com.safeway.testedevoperacional.bean;

import java.util.List;

import com.safeway.testedevoperacional.domain.model.Cliente;
import com.safeway.testedevoperacional.domain.model.Empresa;
import com.safeway.testedevoperacional.domain.model.Produto;
import com.safeway.testedevoperacional.domain.model.Venda;

public class VendaBean {

	public static Venda criarVenda(List<Produto> carrinho, Empresa empresa, Cliente cliente, 
			List<Venda> vendas) {
		Double total = carrinho
				.stream()
				.mapToDouble(Produto::getPreco)
				.sum();
		Double comissaoSistema = total * empresa.getTaxa();
		
		int idVenda = vendas.isEmpty() ? 1 : vendas.get(vendas.size() - 1).getCodigo() + 1;
		Venda venda = new Venda(idVenda, carrinho.stream().toList(), total, 
						comissaoSistema, empresa, cliente);
		empresa.setSaldo(empresa.getSaldo() + total);
		vendas.add(venda);
		
		return venda;
	}

}
