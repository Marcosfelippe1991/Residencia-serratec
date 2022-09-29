package br.com.MenuNavegacao;

import javax.swing.JOptionPane;
import com.br.builder.ProdutoBuilder;
import br.com.cabecalho.Cabecalho;
import br.com.conexao.Conexao;
import br.com.dao.ProdutoDAO;
import br.com.entidade.Produto;

/**
 * Classe responsável por criar o menu de interação de produto.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 */
public class MenuNavegacaoProduto {
	
	/**
	 * Método responsável por listar produtos.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void listarProdutos(Conexao con, String SCHEMA) {
		ProdutoDAO produtoDAO = new ProdutoDAO(con, SCHEMA);
		
		produtoDAO.listarProduto();
	}
	
	/**
	 * Método responsável por criar um novo produto.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void adicionarProduto(Conexao con, String SCHEMA) {
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO(con, SCHEMA);
		ProdutoBuilder produtoBuilder = new ProdutoBuilder();
		
		String nomeProduto = JOptionPane.showInputDialog(null, "Informe o nome do Produto", "Menu cadastro de produto.", JOptionPane.INFORMATION_MESSAGE);
		String custoProduto = JOptionPane.showInputDialog(null, "Informe o custo do Produto", "Menu cadastro de produto.", JOptionPane.INFORMATION_MESSAGE);
		double custoPrudutoInformado = Double.parseDouble(custoProduto);
		String valorUnitario = JOptionPane.showInputDialog(null, "Informe o valor unitario do Produto", "Menu cadastro de produto.", JOptionPane.INFORMATION_MESSAGE);
		double valorUnitarioInformado = Double.parseDouble(valorUnitario);
		
		produto = produtoBuilder
				.definirNomeProduto(nomeProduto)
				.definirCustoProduto(custoPrudutoInformado)
				.definirValorUnitarioProduto(valorUnitarioInformado)
				.build();
		
		produtoDAO.incluirProduto(produto, SCHEMA);
		
		produto = produtoDAO.localizarProduto(produto.getNomeProduto(), 0);
		
		
		if(produto == null) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar o produto.","Menu cadastro de produto.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "produto cadastrado com sucesso !", "Menu cadastro de produto.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por buscar um produto por nome ou identificador.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void encontrarProduto(Conexao con, String SCHEMA) {
		ProdutoDAO produtoDAO = new ProdutoDAO(con, SCHEMA);
		String opcaoUsuario;
		int idProdutoInformado = 0;
		String nomeProduto = null;
		Produto produto = new Produto();
		   
		opcaoUsuario = JOptionPane.showInputDialog(null,"Você deseja consultar por:"
	    													+ "\n(1) - Nome do produto."
	    													+ "\n(2) - IdProduto.", "Menu Consulta Produto", JOptionPane.INFORMATION_MESSAGE);
	    int escolhaUsuario = Integer.parseInt(opcaoUsuario);
	    
	    if(escolhaUsuario == 1) {
	    	nomeProduto = JOptionPane.showInputDialog(null, "Informe o nome do produto: ", "Informe o nome do Produto", JOptionPane.INFORMATION_MESSAGE);
	    	
	    } else if(escolhaUsuario == 2) {
	    	String idProdutoSelecionado = JOptionPane.showInputDialog(null, "Informe o identificador do produto: ", "Informe o ID do Produto", JOptionPane.INFORMATION_MESSAGE);
	    	idProdutoInformado = Integer.parseInt(idProdutoSelecionado);
	    	
	    }else {
	    	JOptionPane.showMessageDialog(null,"A opção digitada é inválida.","Opção Inválida !",JOptionPane.ERROR_MESSAGE);   
	    }
	
	    produto = produtoDAO.localizarProduto(nomeProduto, idProdutoInformado);
	    
	    if(produto == null) {
	    	JOptionPane.showMessageDialog(null,"Produto não encontrado.","Menu Pesquisa de produto.",JOptionPane.ERROR_MESSAGE); 
	    }else {
	    	JOptionPane.showMessageDialog(null,"Produto " + produto.getNomeProduto() + " encontrado.","Menu Pesquisa de produto.",JOptionPane.INFORMATION_MESSAGE); 
	    }
	}
	
	/**
	 * Método responsável por atualizar um produto.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void atualizarProduto(Conexao con, String SCHEMA) {
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO(con, SCHEMA);
		ProdutoBuilder produtoBuilder = new ProdutoBuilder();
		String escolhaUsuario;
		
		String idProdutoParaSerAlterado = JOptionPane.showInputDialog(null, "Informe o ID do produto para ser atualizado",
																			"Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
		int idProduto = Integer.parseInt(idProdutoParaSerAlterado);
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o nome do produto ?"
															+ "\n(1) - Sim"
															+ "\n(0) - Não", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String nomeProduto = JOptionPane.showInputDialog(null, "Informe o nome do Produto", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
			
			produtoBuilder.definirNomeProduto(nomeProduto).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do produto.",JOptionPane.ERROR_MESSAGE);
		}
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o Custo do produto ?"
				+ "\n(1) - Sim"
				+ "\n(0) - Não", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String custoProduto = JOptionPane.showInputDialog(null, "Informe o custo do Produto", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
			double custoProdutoInformado = Double.parseDouble(custoProduto);
			produtoBuilder.definirCustoProduto(custoProdutoInformado).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do produto.",JOptionPane.ERROR_MESSAGE);
		}
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o Valor Unitario do produto ?"
				+ "\n(1) - Sim"
				+ "\n(0) - Não", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String valorUnitarioProduto = JOptionPane.showInputDialog(null, "Informe o telefone do Produto", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
			double valorUnitarioProdutoInformado = Double.parseDouble(valorUnitarioProduto);
			
			produtoBuilder.definirValorUnitarioProduto(valorUnitarioProdutoInformado).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do produto.",JOptionPane.ERROR_MESSAGE);
		}
		
		produto = produtoBuilder.build();
					
		produtoDAO.alterarProduto(produto, idProduto);
		
		produto = produtoDAO.localizarProduto(produto.getNomeProduto(), 0);
		
		if(produto == null) {
			JOptionPane.showMessageDialog(null,"Erro ao alterar o produto.","Menu Atualização do produto.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso !", "Menu Atualização do produto.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por excluir um registro no banco de dados.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void deletarProduto(Conexao con, String SCHEMA) {
		ProdutoDAO produtoDAO = new ProdutoDAO(con, SCHEMA);
		Produto produto = new Produto();
		String idProduto = JOptionPane.showInputDialog(null, "Informe o identificador do Produto:", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		int idProdutoInformado = Integer.parseInt(idProduto);
		
		produto = produtoDAO.localizarProduto(null, idProdutoInformado);
		
		if(produto == null) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado com o ID " + idProdutoInformado, "Menu de exclusão", JOptionPane.ERROR_MESSAGE);
			
		}else {
			produtoDAO.apagarProduto(produto.getIdProduto());
			
			JOptionPane.showMessageDialog(null, "Produto deletado com sucesso !", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por criar o menu de navegação de produto.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void menuProduto(Conexao con, String SCHEMA) {
		MenuNavegacaoPrincipal menuNavegacaoPrincipal = new MenuNavegacaoPrincipal();
		String opcaoUsuario = JOptionPane.showInputDialog(null, "\nEscolha uma das opções abaixo:"
															+ "\n" + Cabecalho.LINHA_FINA 
															+ "\n(1) - Cadastrar Produto: "
															+ "\n(2) - Localizar Produto: "	
															+ "\n(3) - Alterar Produto: "
															+ "\n(4) - Excluir Produto: "
															+ "\n(5) - Listar Produto: "
															+ "\n(6) - Retornar ao menu anterior.", "Menu do Produto", JOptionPane.INFORMATION_MESSAGE);
		
		int escolhaUsuario = Integer.parseInt(opcaoUsuario);
		
		switch (escolhaUsuario) {
			
		   case 1: 
			   	adicionarProduto(con, SCHEMA);
			    menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   	break;
		   case 2:
			    encontrarProduto(con, SCHEMA); 
			    menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			    break;
		   case 3:
			   atualizarProduto(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 4:
			   deletarProduto(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 5:
			   listarProdutos(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 6:
			   menuNavegacaoPrincipal.menuPrincipal(con, SCHEMA);
		   default:
			   System.out.println("Opção inválida, digite novamente: ");
			   menuProduto(con, SCHEMA);
			}
	}
}
