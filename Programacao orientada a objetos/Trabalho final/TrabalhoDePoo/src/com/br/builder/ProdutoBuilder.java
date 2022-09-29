package com.br.builder;

import br.com.entidade.Produto;

public class ProdutoBuilder {

	/**
	 * Classe Builder para gerar um objeto padrão de Produto.
	 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
	 */
	private String nomeProdutoBuilder = "Nome padrao teste";
	private double custoBuilder = 00000;
	private double valorUnitarioBuilder = 111111;
	
	/**
	 * Método responsével por definir o nome do produto.
	 * @param nome - Nome do produto.
	 * @return - Retorna a própria classe.
	 */
	public ProdutoBuilder definirNomeProduto(String nomeProduto) {
		nomeProdutoBuilder = nomeProduto;
		return this;
	}
	
	/**
	 *  Método responsével por definir o custo do produto.
	 * @param defienirCustoProduto - custo do produto.
	 * @return retorna a própria classe.
	 */
	public ProdutoBuilder definirCustoProduto(double custo) {
		custoBuilder = custo;
		return this;
	}
	
	/**
	 *  Método responsével por definir o valor unitario do produto.
	 * @param definirCustoProduto - custo do produto.
	 * @return retorna a própria classe.
	 */
	public ProdutoBuilder definirValorUnitarioProduto(double valorUnitario) {
		valorUnitarioBuilder = valorUnitario;
		return this;
	}
	
	/**
	 *  Método que cria um objeto padrão de produto.
	 * @return Retorna a própria classe.
	 */
	public Produto build() {
		
		Produto produto = new Produto();
		produto.setNomeProduto(nomeProdutoBuilder);
		produto.setCusto(custoBuilder);
		produto.setValorUnitario(valorUnitarioBuilder);
		
		return produto;
	}
}
