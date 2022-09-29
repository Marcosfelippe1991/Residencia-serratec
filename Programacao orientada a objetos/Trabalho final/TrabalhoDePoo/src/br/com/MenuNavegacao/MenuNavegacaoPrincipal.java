package br.com.MenuNavegacao;

import javax.swing.JOptionPane;
import br.com.cabecalho.Cabecalho;
import br.com.conexao.Conexao;

/**
 * Classe responsável pelo menu de navegação.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 */
public class MenuNavegacaoPrincipal {
	
	/**
	 * Método responsável por inserir o cabeçalho do sistema.
	 */
	public String inserirCabecalho( ) {
		String cabecalho = Cabecalho.LINHA_GROSSA 
							+ "\n" + Cabecalho.PROGRAMA
							+ "\n" + "Empresa: " + Cabecalho.NM_EMPRESA
							+ "\n" + "Versão: " + Cabecalho.VERSAO
							+ "\n" + Cabecalho.LINHA_FINA;
		
		return cabecalho;
	}
	
	/**
	 * Método responsável pela criação do menu principal para o usúario.
	 * @param con - Realiza a conexao com o dataBase.
	 * @param SCHEMA - Nome do esquema no dataBase.
	 */
	public void menuPrincipal(Conexao con, String SCHEMA) {
		MenuNavegacaoCliente menuNavegacaoCliente = new MenuNavegacaoCliente();
		MenuNavegacaoProduto menuNavegacaoProduto = new MenuNavegacaoProduto();
		MenuNavegacaoPedido menuNavegacaoPedido = new MenuNavegacaoPedido();
		
		int escolhaUsuario;
		do {
			
			String opcaoUsuario = JOptionPane.showInputDialog(null,"\nEscolha uma das opçoes abaixo:"
																+ "\n" +Cabecalho.LINHA_FINA
																+ "\n(1) - Cliente: "
																+ "\n(2) - Produto: "
																+ "\n(3) - Pedido: " 
																+ "\n(4) - Sair: ", "Menu Principal", JOptionPane.INFORMATION_MESSAGE);
		
			escolhaUsuario = Integer.parseInt(opcaoUsuario);
			
			switch (escolhaUsuario) {
			   case 1: 
				   	menuNavegacaoCliente.menuCliente(con, SCHEMA);
			   case 2:
				   menuNavegacaoProduto.menuProduto(con, SCHEMA);
			   case 3:
				   menuNavegacaoPedido.menuPedido(con, SCHEMA);
			   case 4:
				   JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso sistema.", "Menu Tchau I Have to go now.", JOptionPane.INFORMATION_MESSAGE);
				   System.exit(0);
			   default:
				   System.out.println("Opção inválida, digite novamente: ");
				   menuPrincipal(con, SCHEMA);
				}  
			
		} while (escolhaUsuario!= 0);
	}
}