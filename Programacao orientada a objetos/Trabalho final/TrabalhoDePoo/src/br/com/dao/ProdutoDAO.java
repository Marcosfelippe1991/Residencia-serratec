package br.com.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.conexao.Conexao;
import br.com.entidade.Produto;

/**
 * Classe responsável por cirar os comandos sql de produto.
 * @author Marcos Felippe de Araujo
 *
 */
public class ProdutoDAO {
	private Conexao conexao;
	private String schema;

	PreparedStatement pInclusao = null;

	
	public ProdutoDAO(Conexao conexao, String schema) {
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
		 
	}
	
	/**
	 * Método responsavel por preparar o sql de inclusão de produto.
	 */
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".produto";
		sql = sql + " (nomeproduto, custo, valorunsitario)";
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
	 * Método responsavel por criar o sql de criação de um produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void incluirProduto(Produto produto, String schema) {

		String sql = "insert into " + this.schema + ".produto " + "( nomeproduto, custo, valorunitario) " + "values " + " (" + "'"
				 + produto.getNomeProduto() + "'" + "," + produto.getCusto() + "," + produto.getValorUnitario()
				 + ")";
		conexao.query(sql);
	}
	
	/**
	 * Método responsavel por criar o sql de alteração de um produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void alterarProduto(Produto produto, int idProduto) {
		String sql = "update " + this.schema + ".produto set" + " nomeproduto = '"
				+ produto.getNomeProduto() + "'" + ", custo = '" + produto.getCusto() + "'" + ", valorunitario = '"
				+ produto.getValorUnitario() + "'" + " where idproduto = " + idProduto;
		conexao.query(sql);
	}

	/**
	 * Método responsavel por criar o sql de consulta de um produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Produto selecionarProduto(int idProduto) {
		Produto produto = new Produto();

		ResultSet tabela;

		String sql = "select * from" + this.schema + " .produto where idproduto = " + idProduto;
		tabela = conexao.query(sql);

		try {
			if (tabela.next()) {
				produto.setIdProduto(tabela.getInt("idproduto"));
				produto.setNomeProduto(tabela.getString("nomeproduto"));
				produto.setCusto(tabela.getDouble("custo"));
				produto.setValorUnitario(tabela.getDouble("valorunitario"));
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return produto;
	}

	/**
	 * Método responsavel por criar o sql de exclusão de um produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void apagarProduto(int idProduto) {
		String sql = "delete from " + this.schema + ".produto" + " where idproduto = " + idProduto;

		conexao.query(sql);
	}

	/**
	 * Método responsavel por criar o sql de consulta de um produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public Produto localizarProduto(String nomeProduto, int idProduto) {
		Produto produto = new Produto();

		String sql;
		ResultSet tabela;

		if (nomeProduto == null) {
			sql = "select * from " + this.schema + ".produto where idproduto = " + idProduto;
		} else
			sql = "select * from " + this.schema + ".produto where nomeproduto = '" + nomeProduto + "'";

		tabela = conexao.query(sql);

		try {

			if (tabela.next()) {
				produto.setIdProduto(tabela.getInt("idproduto"));
				produto.setNomeProduto(tabela.getString("nomeproduto"));
				produto.setCusto(tabela.getDouble("custo"));
				produto.setValorUnitario(tabela.getDouble("valorunitario"));

			} else {
				if (nomeProduto == null) {
					System.out.println("Idproduto " + idProduto + " não localizado.");
				} else
					System.out.println("Produto '" + idProduto + "' não localizado.");

				produto = null;
			}

			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return produto;
	}

	/**
	 * Método responsavel por criar o sql para listar produto.
	 * @param cliente - Cliente que será incluído na tabela.
	 * @param schema - Nome do schma no banco de dados.
	 */
	public void listarProduto() {
		ResultSet tabela;

		String sql = "select * from " + this.schema + ".produto order by idproduto";

		tabela = conexao.query(sql);

		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de produtos: " + rowCount);

			if (rowCount > 0) {
				System.out.println("\nCódigo\tNome do Produto\t\t\tcusto\t\tValor Unitario");
			} else {
				System.out.println("\nNão possui dados.");

				return;

			}

			tabela.beforeFirst();

			while (tabela.next()) {

				System.out.printf("  %s\t   %-20s\t\t%s\t\t  %s\n",

						tabela.getInt("idproduto"), tabela.getString("nomeproduto"), tabela.getDouble("custo"),
						tabela.getDouble("valorunitario"));
			}

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}

