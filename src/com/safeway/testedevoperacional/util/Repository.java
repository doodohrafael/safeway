package com.safeway.testedevoperacional.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.safeway.testedevoperacional.domain.model.Cliente;
import com.safeway.testedevoperacional.domain.model.Empresa;
import com.safeway.testedevoperacional.domain.model.Produto;
import com.safeway.testedevoperacional.domain.model.Usuario;
import com.safeway.testedevoperacional.domain.model.Venda;

public class Repository {

	// SIMULANDO BANCO DE DADOS

	public static List<Produto> carrinho = new ArrayList<Produto>();
	public static List<Venda> vendas = new ArrayList<Venda>();

	public static Empresa empresa = new Empresa(2, "SafeWay Padaria", "30021423000159", 0.15, 0.0);
	public static Empresa empresa2 = new Empresa(1, "Level Varejo", "53239160000154", 0.05, 0.0);
	public static Empresa empresa3 = new Empresa(3, "SafeWay Restaurante", "41361511000116", 0.20, 0.0);

	public static Produto produto = new Produto(1, "Pão Frances", 5, 3.50, empresa);
	public static Produto produto2 = new Produto(2, "Coturno", 10, 400.0, empresa2);
	public static Produto produto3 = new Produto(3, "Jaqueta Jeans", 15, 150.0, empresa2);
	public static Produto produto4 = new Produto(4, "Calça Sarja", 15, 150.0, empresa2);
	public static Produto produto5 = new Produto(5, "Prato feito - Frango", 10, 25.0, empresa3);
	public static Produto produto6 = new Produto(6, "Prato feito - Carne", 10, 25.0, empresa3);
	public static Produto produto7 = new Produto(7, "Suco Natural", 30, 10.0, empresa3);
	public static Produto produto8 = new Produto(8, "Sonho", 5, 8.50, empresa);
	public static Produto produto9 = new Produto(9, "Croissant", 7, 6.50, empresa);
	public static Produto produto10 = new Produto(10, "Ché Gelado", 4, 5.50, empresa);

	public static Cliente cliente = new Cliente("07221134049", "Allan da Silva", "cliente", 20);
	public static Cliente cliente2 = new Cliente("72840700050", "Samuel da Silva", "cliente2", 24);

	public static Usuario usuario1 = new Usuario("admin", "1234");
	public static Usuario usuario2 = new Usuario("empresa", "1234", empresa);
	public static Usuario usuario3 = new Usuario("cliente", "1234", cliente);
	public static Usuario usuario4 = new Usuario("cliente2", "1234", cliente2);
	public static Usuario usuario5 = new Usuario("empresa2", "1234", empresa2);
	public static Usuario usuario6 = new Usuario("empresa3", "1234", empresa3);

	public static List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6);
	public static List<Cliente> clientes = Arrays.asList(cliente, cliente2);
	public static List<Empresa> empresas = Arrays.asList(empresa, empresa2, empresa3);
	public static List<Produto> produtos = Arrays.asList(produto, produto2, produto3, produto4, 
			produto5, produto6, produto7, produto8, produto9, produto10);

}
