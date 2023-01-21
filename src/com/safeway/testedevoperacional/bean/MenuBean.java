package com.safeway.testedevoperacional.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.safeway.testedevoperacional.domain.model.Cliente;
import com.safeway.testedevoperacional.domain.model.Empresa;
import com.safeway.testedevoperacional.domain.model.Produto;
import com.safeway.testedevoperacional.domain.model.Usuario;
import com.safeway.testedevoperacional.domain.model.Venda;

import static com.safeway.testedevoperacional.Main.iniciaSistema;
import static com.safeway.testedevoperacional.bean.VendaBean.criarVenda;

public class MenuBean {

	public static void menuPrincipal(List<Usuario> usuarios, List<Cliente> clientes, List<Empresa> empresas,
			List<Produto> produtos, List<Produto> carrinho, List<Venda> vendas, Scanner scanner, Usuario usuarioLogado) {
		System.out.println("\nEscolha uma opção para iniciar");
		if (usuarioLogado.IsEmpresa()) {
			System.out.println("1 - Listar vendas");
			System.out.println("2 - Ver produtos");
			System.out.println("0 - Deslogar");
			Integer escolha = scanner.nextInt();

			switch (escolha) {
			case 1: {
				System.out.println();
				System.out.println("************************************************************");
				System.out.println("VENDAS EFETUADAS");
				if (vendas.size() > 0) {
					vendas.stream().forEach(venda -> {
						if (venda.getEmpresa().getId().equals(usuarioLogado.getEmpresa().getId())) {
							System.out.println("************************************************************");
							System.out.println("Venda de código: " + venda.getCodigo() + " no CPF "
									+ venda.getCliente().getCpf() + ": ");
							venda.getItens().stream().forEach(x -> {
								System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
							});
							System.out.println("\nTotal Venda: R$" + venda.getValor());
							System.out.println("Total Taxa a ser paga: R$" + venda.getComissao());
							System.out.println("Total Líquido  para empresa: "
									+ (venda.getValor() - venda.getComissao()));
							System.out.println("************************************************************");
						}
	
					});
				} else {
					System.out.println("Nenhuma venda ainda foi efetuada.");
				}
				System.out.println("Saldo Empresa: " + usuarioLogado.getEmpresa().getSaldo());
				System.out.println("************************************************************");

				iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
			}
			case 2: {
				System.out.println();
				System.out.println("************************************************************");
				System.out.println("MEUS PRODUTOS");
				produtos.stream().forEach(produto -> {
					if (produto.getEmpresa().getId().equals(usuarioLogado.getEmpresa().getId())) {
						System.out.println("************************************************************");
						System.out.println("Código: " + produto.getId());
						System.out.println("Produto: " + produto.getNome());
						System.out.println("Quantidade em estoque: " + produto.getQuantidade());
						System.out.println("Valor: R$" + produto.getPreco());								
						System.out.println("************************************************************");
					}

				});
				System.out.println("Saldo Empresa: " + usuarioLogado.getEmpresa().getSaldo());
				System.out.println("************************************************************");

				iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
			}
			case 0: {
				iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);

			}
			}

		} else { // Para clientes
			System.out.println("1 - Relizar Compras");
			System.out.println("2 - Ver Compras");
			System.out.println("0 - Deslogar");
			Integer escolha = scanner.nextInt();
			switch (escolha) {
			case 1: {
				System.out.println("\nPara realizar uma compra, escolha a empresa onde deseja comprar: ");
				empresas.stream().forEach(empresa -> {
					System.out.println(empresa.getId() + " - " + empresa.getNome());
				});
				Integer escolhaEmpresa = scanner.nextInt();
				Integer escolhaProduto = -1;
				do {
					List<Produto> produtosEscolhidos = new ArrayList<>();
					System.out.println("\nEscolha os seus produtos: ");
					
					produtosEscolhidos = produtos.stream()
							.filter(p -> p.getEmpresa().getId().equals(escolhaEmpresa))
							.collect(Collectors.toList());
					
					produtosEscolhidos.stream().forEach(produto -> {
						if (produto.getEmpresa().getId().equals(escolhaEmpresa)) {
							System.out.println(produto.getId() + " - " + produto.getNome());
						}
					});
					System.out.println("\n0 - Finalizar compra");
					escolhaProduto = scanner.nextInt();
					if(escolhaProduto == 0) {
						break;
					}
					for (Produto produtoSearch : produtosEscolhidos) {
						if (produtoSearch.getId().equals(escolhaProduto)) {
							carrinho.add(produtoSearch);
							produtoSearch.setQuantidade(
									produtoSearch.getQuantidade() - 1);
							break;
						}
					}
				} while (escolhaProduto != 0);
				System.out.println("************************************************************");
				System.out.println("Resumo da compra: ");
				carrinho.stream().forEach(produto -> {
					if (produto.getEmpresa().getId().equals(escolhaEmpresa)) {
						System.out.println(produto.getId() + " - " + produto.getNome() + 
								"    R$" + produto.getPreco());
					}
				});
				if(carrinho.size() > 0) {
					Empresa empresaEscolhida = empresas.stream()
							.filter(empresa -> empresa.getId().equals(escolhaEmpresa))
							.collect(Collectors.toList()).get(0);
					Cliente clienteLogado = clientes.stream()
							.filter(cliente -> cliente.getUsername()
									.equals(usuarioLogado.getUsername()))
							.collect(Collectors.toList()).get(0);
					Venda venda = criarVenda(carrinho, empresaEscolhida, clienteLogado, vendas);
					System.out.println("Total: R$" + venda.getValor());
					System.out.println("************************************************************");
					carrinho.clear();
					iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
				} 
			}
			case 2: {
				System.out.println();
				System.out.println("************************************************************");
				System.out.println("COMPRAS EFETUADAS");
				vendas.stream().forEach(venda -> {
					if (venda.getCliente().getUsername().equals(usuarioLogado.getUsername())) {
						System.out.println("************************************************************");
						System.out.println("Compra de código: " + venda.getCodigo() + " na empresa "
								+ venda.getEmpresa().getNome() + ": ");
						venda.getItens().stream().forEach(x -> {
							System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
						});
						System.out.println("Total: R$" + venda.getValor());
						System.out.println("************************************************************");
					}
				});
					iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
				} 
			case 0: {
				iniciaSistema(usuarios, clientes, empresas, produtos, carrinho, vendas);
			}

			}
		}
	}
	
}
