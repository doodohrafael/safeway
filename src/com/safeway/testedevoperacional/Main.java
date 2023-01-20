package com.safeway.testedevoperacional;
import static com.safeway.testedevoperacional.bean.LoginBean.login;
import static com.safeway.testedevoperacional.util.Repository.carrinho;
import static com.safeway.testedevoperacional.util.Repository.clientes;
import static com.safeway.testedevoperacional.util.Repository.empresas;
import static com.safeway.testedevoperacional.util.Repository.produtos;
import static com.safeway.testedevoperacional.util.Repository.usuarios;
import static com.safeway.testedevoperacional.util.Repository.vendas;

import java.util.List;

import com.safeway.testedevoperacional.domain.model.Cliente;
import com.safeway.testedevoperacional.domain.model.Empresa;
import com.safeway.testedevoperacional.domain.model.Produto;
import com.safeway.testedevoperacional.domain.model.Usuario;
import com.safeway.testedevoperacional.domain.model.Venda;

public class Main {

	public static void main(String[] args) {
		iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
	}
	
	public static void iniciaSistema(List<Usuario> usuarios, List<Cliente> clientes, List<Empresa> empresas,
			List<Produto> produtos, List<Produto> carrinho, List<Venda> vendas) {
		login(usuarios, clientes, empresas, produtos, carrinho, vendas);
	}
	
}
