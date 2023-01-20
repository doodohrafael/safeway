package com.safeway.testedevoperacional.bean;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.safeway.testedevoperacional.domain.model.Cliente;
import com.safeway.testedevoperacional.domain.model.Empresa;
import com.safeway.testedevoperacional.domain.model.Produto;
import com.safeway.testedevoperacional.domain.model.Usuario;
import com.safeway.testedevoperacional.domain.model.Venda;

import static com.safeway.testedevoperacional.bean.MenuBean.menuPrincipal;

public class LoginBean {
	
	public static void login(List<Usuario> usuarios, List<Cliente> clientes, List<Empresa> empresas,
			List<Produto> produtos, List<Produto> carrinho, List<Venda> vendas) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com seu usuário e senha:");
		System.out.print("Usuário: ");
		String username = sc.next();
		System.out.print("Senha: ");
		String senha = sc.next();
		
		List<Usuario> usuariosSearch = usuarios
				.stream()
				.filter(x -> x.getUsername().equals(username))
				.collect(Collectors.toList());
		
		if (usuariosSearch.size() > 0) {
			Usuario usuarioLogado = usuariosSearch.get(0);
			if ((usuarioLogado.getSenha().equals(senha))) {
				menuPrincipal(usuarios, clientes, empresas, 
						produtos, carrinho, vendas, sc, usuarioLogado);
			} else
				System.err.println("Senha incorreta");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

}
