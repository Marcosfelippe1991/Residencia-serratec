package com.br.builder;

import br.com.entidade.Cliente;

/**
 * Classe responsável por criar o objeto padrão de cliente com seus atributos já valorados.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 *
 */
public class ClienteBuilder {

	private String nomeBuilder = "Nome padrão para teste";
	private String cpfBuilder = "00000000000";
	private String telefoneBuilder = "111111111";
	
	/**
	 * Método responsével por definir o nome do cliente.
	 * @param nome - Nome do cliente.
	 * @return - Retorna a própria classe.
	 */
	public ClienteBuilder definirNomeCliente(String nome) {
		nomeBuilder = nome;
		return this;
	}
	
	/**
	 *  Método responsável por definir o CPF do cliente.
	 * @param definirCpfCliente - Cpf do cliente.
	 * @return retorna a própria classe.
	 */
	public ClienteBuilder definirCpfCliente(String cpf) {
		cpfBuilder = cpf;
		return this;
	}
	
	/**
	 *  Método responsével por definir o telefone do cliente.
	 * @param definirTelefoneCliente - Telefone do cliente.
	 * @return retorna a própria classe.
	 */
	public ClienteBuilder definirTelefoneCliente(String telefone) {
		telefoneBuilder = telefone;
		return this;
	}
	
	/**
	 *  Método que cria um objeto padrão de cliente.
	 * @return Retorna a própria classe.
	 */
	public Cliente build() {
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeBuilder);
		cliente.setCpf(cpfBuilder);
		cliente.setTelefone(telefoneBuilder);
		
		return cliente;
	}
}
