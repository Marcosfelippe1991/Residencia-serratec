package br.com.MenuNavegacao;

import javax.swing.JOptionPane;

import com.br.builder.PedidoBuilder;

import br.com.cabecalho.Cabecalho;
import br.com.conexao.Conexao;
import br.com.dao.PedidoDAO;
import br.com.entidade.Pedido;

/**
 * Classe responsável por criar o menu de interação de pedido.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 */
public class MenuNavegacaoPedido {
	
	/**
	 * Método responsável por listar pedidos.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void listarPedidos(Conexao con, String SCHEMA) {
		PedidoDAO pedidoDAO = new PedidoDAO(con, SCHEMA);
		
		pedidoDAO.listarPedido();
	}
	
	/**
	 * Método responsável por adicionar um novo pedido.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void adicionarPedido(Conexao con, String SCHEMA) {
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO(con, SCHEMA);
		PedidoBuilder pedidoBuilder = new PedidoBuilder();
		
		String valorPedido = JOptionPane.showInputDialog(null, "Informe o valor do pedido", "Menu cadastro de pedido.", JOptionPane.INFORMATION_MESSAGE);
		double valorPedidoInformado = Double.parseDouble(valorPedido);
		String dataEmissao = JOptionPane.showInputDialog(null, "Informe a data de emissão do pedido.", "Menu cadastro de pedido.", JOptionPane.INFORMATION_MESSAGE);
		
		pedido = pedidoBuilder
					.definirValorTotalPedido(valorPedidoInformado)
					.definirDataEmissaoPedido(dataEmissao)
					.build();
					
		pedidoDAO.incluirPedido(pedido, SCHEMA);
		
		pedido = pedidoDAO.localizarPedido(pedido.getDataEmissao(), 0);
			
		if(pedido == null) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar o pedido.","Menu cadastro de pedido.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso !", "Menu cadastro de pedido.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por buscar um novo pedido por data de emissão ou identificador.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void encontrarPedido(Conexao con, String SCHEMA) {
		PedidoDAO pedidoDAO = new PedidoDAO(con, SCHEMA);
		Pedido pedido = new Pedido();
		
		String opcaoUsuario;
		String dataEmissao = null;
		int idPedidoInformado = 0;
		   
		opcaoUsuario = JOptionPane.showInputDialog(null,"Você deseja consultar por:"
	    													+ "\n(1) - Data de emissão do pedido."
	    													+ "\n(2) - IdPedido.", "Menu Consulta Pedido", JOptionPane.INFORMATION_MESSAGE);
	    int escolhaUsuario = Integer.parseInt(opcaoUsuario);
	    
	    if(escolhaUsuario == 1) {
	    	dataEmissao = JOptionPane.showInputDialog(null, "Informe a data de emissão do pedido: ", "Informe o nome do Pedido", JOptionPane.INFORMATION_MESSAGE);
	    	
	    } else if(escolhaUsuario == 2) {
	    	String idPedidoSelecionado = JOptionPane.showInputDialog(null, "Informe o identificador do pedido: ", "Informe o ID do Pedido", JOptionPane.INFORMATION_MESSAGE);
	    	idPedidoInformado = Integer.parseInt(idPedidoSelecionado);
	    }else {
	    	JOptionPane.showMessageDialog(null,"A opção digitada é inválida.","Opção Inválida !",JOptionPane.ERROR_MESSAGE);   
	    }
	
	    pedido = pedidoDAO.localizarPedido(dataEmissao, idPedidoInformado);
	    
	    if(pedido == null) {
	    	JOptionPane.showMessageDialog(null,"Pedido não encontrado.","Menu Pesquisa de pedido.",JOptionPane.ERROR_MESSAGE); 
	    }else {
	    	JOptionPane.showMessageDialog(null,"Pedido " + pedido.getIdPedido() + " encontrado.","Menu Pesquisa de pedido.",JOptionPane.INFORMATION_MESSAGE); 
	    }
	}
	
	/**
	 * Método responsável por alterar um pedido.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void atualizarPedido(Conexao con, String SCHEMA) {
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO(con, SCHEMA);
		PedidoBuilder pedidoBuilder = new PedidoBuilder();
		
		String escolhaUsuario;
		
		String idPedidoParaSerAlterado = JOptionPane.showInputDialog(null, "Informe o ID do pedido para ser atualizado",
																			"Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
		int idPedido = Integer.parseInt(idPedidoParaSerAlterado);
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar a data de emissão do pedido ?"
															+ "\n(1) - Sim"
															+ "\n(0) - Não", "Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String dataEmissaoPedido = JOptionPane.showInputDialog(null, "Informe a nova data de emissão do pedido.", "Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
			
			pedidoBuilder.definirDataEmissaoPedido(dataEmissaoPedido).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do pedido.",JOptionPane.ERROR_MESSAGE);
		}
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o valor total do pedido ?"
				+ "\n(1) - Sim"
				+ "\n(0) - Não", "Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String valorTotalPedido = JOptionPane.showInputDialog(null, "Informe o valor total do pedido", "Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
			double valorTotalPedidoInformado = Double.parseDouble(valorTotalPedido);
			
			pedidoBuilder.definirValorTotalPedido(valorTotalPedidoInformado).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do pedido.",JOptionPane.ERROR_MESSAGE);
		}
		
		pedido = pedidoBuilder.build();
					
		pedidoDAO.alterarPedido(pedido, idPedido);
		
		pedido = pedidoDAO.localizarPedido(pedido.getDataEmissao(), 0);
		
		if(pedido == null) {
			JOptionPane.showMessageDialog(null,"Erro ao alterar o pedido.","Menu Atualização do pedido.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Pedido alterado com sucesso !", "Menu Atualização do pedido.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por deletar um novo pedido por identificador.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void deletarPedido(Conexao con, String SCHEMA) {
		PedidoDAO pedidoDAO = new PedidoDAO(con, SCHEMA);
		Pedido pedido = new Pedido();
		String idPedido = JOptionPane.showInputDialog(null, "Informe o identificador do pedido:", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		int idPedidoInformado = Integer.parseInt(idPedido);
		
		pedido = pedidoDAO.localizarPedido(null, idPedidoInformado);
		
		if(pedido == null) {
			 JOptionPane.showMessageDialog(null, "Pedido não encontrado com o ID " + idPedidoInformado, "Menu de exclusão", JOptionPane.ERROR_MESSAGE);
			 
		}else {
			pedidoDAO.apagarPedido(pedido.getIdPedido());
			
			JOptionPane.showMessageDialog(null, "Pedido deletado com sucesso !", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por criar o menu de navegação de pedido.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void menuPedido(Conexao con, String SCHEMA) {
		MenuNavegacaoPrincipal menuNavegacaoPrincipal = new MenuNavegacaoPrincipal();
		String opcaoUsuario = JOptionPane.showInputDialog(null, "\nEscolha uma das opções abaixo:"
															+ "\n" + Cabecalho.LINHA_FINA 
															+ "\n(1) - Cadastrar Pedido: "
															+ "\n(2) - Localizar Pedido: "	
															+ "\n(3) - Alterar Pedido: "
															+ "\n(4) - Excluir Pedido: "
															+ "\n(5) - Listar Pedido: "
															+ "\n(6) - Retornar ao menu anterior.: ", "Menu do Pedido", JOptionPane.INFORMATION_MESSAGE);
		
		int escolhaUsuario = Integer.parseInt(opcaoUsuario);
		
		switch (escolhaUsuario) {
			
		   case 1: 
			   	adicionarPedido(con, SCHEMA);
			    menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   	break;
		   case 2:
			    encontrarPedido(con, SCHEMA);
			    menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			    break;
		   case 3:
			   atualizarPedido(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 4:
			   deletarPedido(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 5:
			   listarPedidos(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 6:
			   menuNavegacaoPrincipal.menuPrincipal(con, SCHEMA);
		   default:
			   System.out.println("Opção inválida, digite novamente: ");
			   menuPedido(con, SCHEMA);
			}
	}
}
