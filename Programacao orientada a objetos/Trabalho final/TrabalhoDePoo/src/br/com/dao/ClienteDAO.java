package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.conexao.Conexao;
import br.com.entidade.Cliente;

/**
 * Classe responsável por cirar os comandos sql de cliente.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 *
 */
public class ClienteDAO {
	
	private Conexao conexao;
	private String schema;
	PreparedStatement pInclusao = null;

	public ClienteDAO(Conexao conexao, String schema) {
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
	}
	
	/**
	 * Método responsavel por preparar o sql de inclusão de cliente.
	 */
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".cliente";
		sql = sql + " (nome,cpf,telefone)";
		sql = sql + " values ";
		sql = sql + " (?, ?, ?)";
		
		try {
			pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsavel por criar o sql de criação de um cliente.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void incluirCliente(Cliente cliente, String schema) {

		String sql = "insert into " + this.schema + ".cliente " + "(nome, cpf, telefone) "
				+ "values " + " (" + "'" + cliente.getNome() + "'" + "," + "'" + cliente.getCpf() + "'" + "," + "'" + cliente.getTelefone() + "'" + ")";

		conexao.query(sql);
	}
	
	/**
	 * Método responsavel por criar o sql de alteração de um cliente.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void alterarCliente(Cliente cliente, int idCliente) {
		String sql = "update " + this.schema + ".cliente set" + " nome = '" + cliente.getNome() + "'" 
				+ ", cpf = '" + cliente.getCpf() + "'" + ", telefone = '"
				+ cliente.getTelefone() + "'" + "where " + "idCliente" + "=" + "'" + idCliente + "'";

		conexao.query(sql);
	}
	
	/**
	 * Método responsavel por criar o sql de consulta de um cliente.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Cliente selecionarCliente(int idCliente) {
		Cliente cliente = new Cliente();

		ResultSet tabela;

		String sql = "select * from" + this.schema + " .cliente where idcliente = " + idCliente;
		tabela = conexao.query(sql);

		try {
			if (tabela.next()) {
				cliente.setIdCliente(tabela.getInt("idcliente"));
				cliente.setNome(tabela.getString("nome"));
				cliente.setCpf(tabela.getString("cpf"));
				cliente.setTelefone(tabela.getString("telefone"));
				
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return cliente;
	}
	
	/**
	 * Método responsavel por criar o sql de exclusão de um cliente.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void apagarCliente(int idCliente) {
		String sql = "delete from " + this.schema + ".cliente" + " where idcliente = " + idCliente;

		conexao.query(sql);
	}
	
	/**
	 * Método responsavel por criar o sql de consulta de um cliente.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Cliente localizarCliente(String nome, int idCliente) {
		Cliente cliente = new Cliente();

		String sql;
		ResultSet tabela;

		if (nome == null) {
			sql = "select * from " + this.schema + ".cliente where idcliente = " + idCliente;
		} else
			sql = "select * from " + this.schema + ".cliente where nome = '" + nome + "'";

		tabela = conexao.query(sql);
		
		
		try {

			if (tabela.next()) {
				cliente.setIdCliente(tabela.getInt("idcliente"));
				cliente.setNome(tabela.getString("nome"));
				cliente.setCpf(tabela.getString("cpf"));
				cliente.setTelefone(tabela.getString("telefone"));

			} else {
				if (nome == null) {
					System.out.println("IdCliente " + idCliente + " não localizado.");
				} else
					System.out.println("Cliente " + nome + " não localizado.");

				cliente = null;
			}

			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return cliente;
	}
	
	/**
	 * Método responsavel por criar o sql para listar clientes.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void listarClientes() {
		ResultSet tabela;
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();

		String sql = "select * from " + this.schema + ".cliente order by idcliente";

		tabela = conexao.query(sql);

		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de clientes: " + rowCount);

			if (rowCount > 0) {
				System.out.println("\nCódigo\t  Nome\t\t\t  CPF\t\tTelefone");
				
			} else {
				System.out.println("\nNão possui dados.");
				return;
			}

			tabela.beforeFirst();

			while (tabela.next()) {

				System.out.printf("  %s\t%-20s\t%s\t\t%s\t\n",

						tabela.getInt("idcliente"), tabela.getString("Nome"),tabela.getString("Cpf"),
						tabela.getString("Telefone"));
						
						cliente.setIdCliente(tabela.getInt("idcliente"));
						cliente.setNome(tabela.getString("nome"));
						cliente.setCpf(tabela.getString("cpf"));
						cliente.setTelefone(tabela.getString("telefone"));
						
						listaClientes.add(cliente);
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}