package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.conexao.Conexao;
import br.com.entidade.Pedido;

/**
 * Classe responsável por cirar os comandos sql de pedido.
 * @author Marcos Felippe de Araujo
 *
 */
public class PedidoDAO {
	private Conexao conexao;
	private String schema;

	PreparedStatement pInclusao = null;
	
	public PedidoDAO(Conexao conexao, String schema) {
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
		 
	}
	
	/**
	 * Método responsavel por preparar o sql de inclusão de pedido.
	 */
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".pedido";
		sql = sql + " (valortotal, dataemissao)";
		sql = sql + " values ";
		sql = sql + " (?, ?)";
		
		try {
			pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsavel por criar o sql de criação de um pedido.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void incluirPedido(Pedido pedido, String schema) {

		String sql = "insert into " + this.schema + ".pedido " + "(valortotal, dataemissao) " + "values " + " ("
				+ pedido.getValorTotal() + "," + "'" + pedido.getDataEmissao() + "'" + ")";

		conexao.query(sql);
	}
	
	/**
	 * Método responsavel por criar o sql de alteração de um pedido.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void alterarPedido(Pedido pedido, int idPedido) {
		String sql = "update " + this.schema + ".pedido set" + " valortotal = '" + pedido.getValorTotal() + "'" + ",dataemissao = '"
				+ pedido.getDataEmissao() + "'"  + "where idpedido = " + idPedido;

		conexao.query(sql);
	}

	/**
	 * Método responsavel por criar o sql de consulta de um pedido.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Pedido selecionarPedido(int idPedido) {
		Pedido pedido = new Pedido();

		ResultSet tabela;

		String sql = "select * from" + this.schema + " .pedido where idpedido = " + idPedido;
		tabela = conexao.query(sql);

		try {
			if (tabela.next()) {
				pedido.setIdPedido(tabela.getInt("idpedido"));
				pedido.setValorTotal(tabela.getDouble("valortotal"));
				pedido.setDataEmissao(tabela.getString("dataemissao"));
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return pedido;
	}

	/**
	 * Método responsavel por criar o sql de exclusão de um pedido.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void apagarPedido(int idPedido) {
		String sql = "delete from " + this.schema + ".pedido" + " where idpedido = " + idPedido;

		conexao.query(sql);
	}

	/**
	 * Método responsavel por criar o sql de consulta de um pedido.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Pedido localizarPedido(String dataEmissao, int idPedido) {
		Pedido pedido = new Pedido();

		String sql;
		ResultSet tabela;

		if (dataEmissao == null) {
			sql = "select * from " + this.schema + ".pedido where idpedido = " + idPedido;
		} else
			sql = "select * from " + this.schema + ".pedido where dataemissao = '" + dataEmissao + "'";

		tabela = conexao.query(sql);

		try {

			if (tabela.next()) {
				pedido.setIdPedido(tabela.getInt("idpedido"));
				pedido.setValorTotal(tabela.getDouble("valortotal"));
				pedido.setDataEmissao(tabela.getString("dataemissao"));
				

			} else {
				if (dataEmissao == null) {
					System.out.println("Idpedido " + idPedido + " não localizado.");
				} else
					System.out.println("dataemissao '" + dataEmissao + "' não localizado.");

				pedido = null;
			}

			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return pedido;
	}

	/**
	 * Método responsavel por criar o sql para listar clientes.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void listarPedido() {
		ResultSet tabela;

		String sql = "select * from " + this.schema + ".pedido order by idpedido";

		tabela = conexao.query(sql);

		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de pedidos: " + rowCount);

			if (rowCount > 0) {
				System.out.println("\nCódigo\tvalor do pedido\t\tdata de emissao");
			} else {
				System.out.println("\nNão possui dados.");

				return;

			}

			tabela.beforeFirst();

			while (tabela.next()) {

				System.out.printf("  %s\t     %-20s %s\t\n",

						tabela.getInt("idpedido"), tabela.getDouble("valortotal"), tabela.getString("dataemissao"));
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
