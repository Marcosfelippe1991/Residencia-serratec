package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.conexao.Conexao;
import br.com.entidade.PedidoItem;

public class PedidoItemDAO {

	private Conexao conexao;
	private String schema;

	PreparedStatement pInclusao = null;

	public PedidoItemDAO(Conexao conexao, String schema) {
		this.conexao = conexao;
		this.schema = schema;
		prepararSqlInclusao();
		 
	}
	
	private void prepararSqlInclusao() {
		String sql = "insert into "+ this.schema + ".pedidoitem";
		sql = sql + " (valorVendaUnidade, quantidadePedidoItem, valorDesconto, PorcetagemDesconto)";
		sql = sql + " values ";
		sql = sql + " (?, ?, ?, ?)";
		
		try {
			pInclusao =  conexao.getC().prepareStatement(sql);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	
	public void incluirPedidoItem(PedidoItem pedidoItem, String schema) {

		String sql = "insert into " + this.schema + ".pedidoitem " + "( valorvendaunidade, quantidadeproduto, valordesconto, porcentagemdesconto) " + 
					"values " + " (" + "'" + pedidoItem.getValorVendaUnidade() + "'" + "," + pedidoItem.getQuantidadeProduto() + ","
					+ pedidoItem.getValorDesconto() +  "," + pedidoItem.getPorcetagemDesconto() + ")";
		
		conexao.query(sql);
	}
	
	public void alterarPedidoItem(PedidoItem pedidoItem, int idPedidoItem) {
		String sql = "update " + this.schema + ".pedidoitem set" + " valorvendaunidade = '"
				+ pedidoItem.getValorVendaUnidade() + "'" + ", quantidadeproduto = '" + pedidoItem.getQuantidadeProduto() + "'" + ", valordesconto = '"
				+ pedidoItem.getValorDesconto() + "'" + "'" + ", porcentagemdesconto = '"
				+ pedidoItem.getPorcetagemDesconto() + "'" + " where idpedidoItem = " + idPedidoItem;
		conexao.query(sql);
	}

	public PedidoItem selecionarPedidoItem(int idPedidoItem) {
		PedidoItem pedidoItem = new PedidoItem();

		ResultSet tabela;

		String sql = "select * from" + this.schema + " .pedidoitem where idpedidoitem = " + idPedidoItem;
		tabela = conexao.query(sql);

		try {
			if (tabela.next()) {
				pedidoItem.setValorVendaUnidade(tabela.getDouble("valorvendaunidade"));
				pedidoItem.setQuantidadeProduto(tabela.getDouble("quantidadeproduto"));
				pedidoItem.setValorDesconto(tabela.getDouble("valordesconto"));
				pedidoItem.setPorcetagemDesconto(tabela.getDouble("porcentagemdesconto"));
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return pedidoItem;
	}

	public void apagarPedidoItem(int idPedidoItem) {
		String sql = "delete from " + this.schema + ".pedidoitem" + " where idpedidoitem = " + idPedidoItem;

		conexao.query(sql);
	}

	public PedidoItem localizarPedidoItem(int idPedidoItem) {
		PedidoItem pedidoItem = new PedidoItem();

		String sql;
		ResultSet tabela;
		sql = "select * from " + this.schema + ".pedidoItem where idpedidoItem = " + idPedidoItem;

		tabela = conexao.query(sql);

		try {

			if (tabela.next()) {
				pedidoItem.setValorVendaUnidade(tabela.getDouble("valorvendaunidade"));
				pedidoItem.setQuantidadeProduto(tabela.getDouble("quantidadeproduto"));
				pedidoItem.setValorDesconto(tabela.getDouble("valordesconto"));
				pedidoItem.setPorcetagemDesconto(tabela.getDouble("porcentagemdesconto"));

			} else {
				if (idPedidoItem == 0) {
					System.out.println("IdpedidoItem " + idPedidoItem + " não localizado.");
				} else
					System.out.println("PedidoItem '" + idPedidoItem + "' não localizado.");

				pedidoItem = null;
			}

			tabela.close();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return pedidoItem;
	}

	public void listarPedidoItem() {
		ResultSet tabela;

		String sql = "select * from " + this.schema + ".pedidoItem order by idpedidoitem";

		tabela = conexao.query(sql);

		try {
			tabela.last();
			int rowCount = tabela.getRow();
			System.out.println("Quantidade de pedidoitems: " + rowCount);

			if (rowCount > 0) {
				System.out.println("\nvalorvendapedido\tquantidadeproduto\t\tvalordesconto\t\t\tporcetagemdesconto");
			} else {
				System.out.println("\nNão possui dados.");

				return;

			}

			tabela.beforeFirst();

			while (tabela.next()) {

				System.out.printf("%s\t'%-20s'\t%s\t%s\n",

						tabela.getInt("idpedidoItem"), tabela.getDouble("valorvendapedido"), tabela.getDouble("quantidadeproduto"),
						tabela.getDouble("valordesconto"), tabela.getDouble("porcentagemdesconto"));
			}

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
