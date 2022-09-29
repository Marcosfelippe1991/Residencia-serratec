package com.br.builder;

import br.com.entidade.Pedido;

/**
 * Classe Builder para gerar um objeto padrão de Pedido.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 */
public class PedidoBuilder {

	private double valorTotal = 10.90;
	private String dataEmissao = "10/09/1998";
	
	/**
	 * Método responsável por defirnir o valor total do pedido.
	 * @param valorTotalPedido - Valor total do pedido.
	 * @return Retorna a própria classe.
	 */
	public PedidoBuilder definirValorTotalPedido(double valorTotalPedido) {
		
		valorTotal = valorTotalPedido;
		return this;
	}
	
	/**
	 * Método responsável por defirnir a data de emissão do pedido.
	 * @param dataEmissaoPedido - data de emissão do pedido.
	 * @return Retorna a própria classe.
	 */
	public PedidoBuilder definirDataEmissaoPedido(String dataEmissaoPedido) {
		
		dataEmissao = dataEmissaoPedido;
		return this;
	}
	
	/**
	 * Método responsável por gerar um objeto padrão de Pedido.
	 * @return Retorna um novo objeto de Pedido já preenchido.
	 */
	public Pedido build() {
		Pedido pedido = new Pedido();
		
		pedido.setValorTotal(valorTotal);
		pedido.setDataEmissao(dataEmissao);
		
		return pedido;
	}
}
