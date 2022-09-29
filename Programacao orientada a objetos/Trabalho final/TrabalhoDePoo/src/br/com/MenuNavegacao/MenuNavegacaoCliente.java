package br.com.MenuNavegacao;

import javax.swing.JOptionPane;
import com.br.builder.ClienteBuilder;
import br.com.cabecalho.Cabecalho;
import br.com.conexao.Conexao;
import br.com.dao.ClienteDAO;
import br.com.entidade.Cliente;

/**
 * Classe responsável pelo menu de interação de cliente.
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 */
public class MenuNavegacaoCliente {

	/**
	 * Método responsável por listar todos os clientes.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do eschema na tabela.
	 */
	public void listarClientes(Conexao con, String SCHEMA) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		
		clienteDAO.listarClientes();
	}
	
	/**
	 * Método responsável por criar um novo cliente.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void adicionarCliente(Conexao con, String SCHEMA) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		ClienteBuilder clienteBuilder = new ClienteBuilder();
		
		String nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do Cliente", "Menu cadastro de cliente.", JOptionPane.INFORMATION_MESSAGE);
		String cpfCliente = JOptionPane.showInputDialog(null, "Informe o cpf do Cliente", "Menu cadastro de cliente.", JOptionPane.INFORMATION_MESSAGE);
		String telefoneCliente = JOptionPane.showInputDialog(null, "Informe o telefone do Cliente", "Menu cadastro de cliente.", JOptionPane.INFORMATION_MESSAGE);
		
		
		cliente = clienteBuilder
				.definirNomeCliente(nomeCliente)
				.definirCpfCliente(cpfCliente)
				.definirTelefoneCliente(telefoneCliente)
				.build();
		
		clienteDAO.incluirCliente(cliente, SCHEMA);
		
		cliente = clienteDAO.localizarCliente(cliente.getNome(), 0);
		
		if(cliente == null) {
			JOptionPane.showMessageDialog(null,"Erro ao cadastrar o cliente.","Menu cadastro de cliente.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso !", "Menu cadastro de cliente.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por buscar um cliente por nome ou identificador.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void encontrarCliente(Conexao con, String SCHEMA) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		String opcaoUsuario;
		int idClienteInformado = 0;
		String nomeCliente = null;
		Cliente cliente = new Cliente();
		
		opcaoUsuario = JOptionPane.showInputDialog(null,"Você deseja consultar por:"
				+ "\n(1) - Nome."
				+ "\n(2) - IdCliente.", "Menu Consulta Cliente", JOptionPane.INFORMATION_MESSAGE);
		int escolhaUsuario = Integer.parseInt(opcaoUsuario);
		
		if(escolhaUsuario == 1) {
			nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente: ", "Informe o nome do Cliente", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(escolhaUsuario == 2) {
			String idClienteSelecionado = JOptionPane.showInputDialog(null, "Informe o identificador do cliente: ", "Informe o ID do Cliente", JOptionPane.INFORMATION_MESSAGE);
			idClienteInformado = Integer.parseInt(idClienteSelecionado);
			
		}else {
			JOptionPane.showMessageDialog(null,"A opção digitada é inválida.","Opção Inválida !",JOptionPane.ERROR_MESSAGE);   
		}
		
		cliente = clienteDAO.localizarCliente(nomeCliente, idClienteInformado);
		
		if(cliente == null) {
			JOptionPane.showMessageDialog(null,"Cliente não encontrado.","Menu Pesquisa de cliente.",JOptionPane.ERROR_MESSAGE); 
		}else {
			JOptionPane.showMessageDialog(null,"Cliente " + cliente.getNome() + " encontrado.","Menu Pesquisa de cliente.",JOptionPane.INFORMATION_MESSAGE); 
		}
	}
	
	/**
	 * Método responsável por atualização as informações de um Cliente.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - nome do schema no banco de dados.
	 */
	public void atualizarCliente(Conexao con, String SCHEMA) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		ClienteBuilder clienteBuilder = new ClienteBuilder();
		String escolhaUsuario;
		
		String idClienteParaSerAlterado = JOptionPane.showInputDialog(null, "Informe o ID do cliente para ser atualizado",
																			"Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
		int idCliente = Integer.parseInt(idClienteParaSerAlterado);
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o nome do cliente ?"
															+ "\n(1) - Sim"
															+ "\n(0) - Não", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do Cliente", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
			
			clienteBuilder.definirNomeCliente(nomeCliente).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do cliente.",JOptionPane.ERROR_MESSAGE);
		}
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o CPF do cliente ?"
				+ "\n(1) - Sim"
				+ "\n(0) - Não", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String cpfCliente = JOptionPane.showInputDialog(null, "Informe o cpf do Cliente", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
			
			clienteBuilder.definirCpfCliente(cpfCliente).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do cliente.",JOptionPane.ERROR_MESSAGE);
		}
		
		escolhaUsuario = JOptionPane.showInputDialog(null, "Você deseja alterar o Telefone do cliente ?"
				+ "\n(1) - Sim"
				+ "\n(0) - Não", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
		
		if(escolhaUsuario.equals("1")) {
			String telefoneCliente = JOptionPane.showInputDialog(null, "Informe o telefone do Cliente", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
			
			clienteBuilder.definirTelefoneCliente(telefoneCliente).build();
		}else if(escolhaUsuario.equals("0")) {
			
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Menu Atualização do cliente.",JOptionPane.ERROR_MESSAGE);
		}
		
		cliente = clienteBuilder.build();
					
		clienteDAO.alterarCliente(cliente, idCliente);
		
		cliente = clienteDAO.localizarCliente(cliente.getNome(), 0);
		
		if(cliente == null) {
			JOptionPane.showMessageDialog(null,"Erro ao alterar o cliente.","Menu Atualização do cliente.",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso !", "Menu Atualização do cliente.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método responsável por excluir um registro no banco de dados.
	 * @param con - Variável de conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void deletarCliente(Conexao con, String SCHEMA) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		Cliente cliente = new Cliente();
		String idCliente = JOptionPane.showInputDialog(null, "Informe o identificador do cliente:", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		int idClienteInformado = Integer.parseInt(idCliente);
		
		cliente = clienteDAO.localizarCliente(null, idClienteInformado);
		
		if(cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado com o ID " + idClienteInformado, "Menu de exclusão", JOptionPane.ERROR_MESSAGE);
			
		}else {
			clienteDAO.apagarCliente(cliente.getIdCliente());
			
			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso !", "Menu de exclusão", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método Responsável por criar o menu de interação do cliente.
	 * @param con - Realiza a conexão com o banco de dados.
	 * @param SCHEMA - Nome do schema no banco de dados.
	 */
	public void menuCliente(Conexao con, String SCHEMA) {
		MenuNavegacaoPrincipal menuNavegacaoPrincipal = new MenuNavegacaoPrincipal();
		
		String opcaoUsuario = JOptionPane.showInputDialog(null, "\nEscolha uma das opções abaixo:"
															+ "\n" + Cabecalho.LINHA_FINA 
															+ "\n(1) - Cadastrar Cliente: "
															+ "\n(2) - Localizar Cliente: "	
															+ "\n(3) - Alterar Cliente: "
															+ "\n(4) - Excluir Cliente: "
															+ "\n(5) - Listar Cliente: "
															+ "\n(6) - Retornar ao menu anterior.", "Menu do Cliente", JOptionPane.INFORMATION_MESSAGE);
		
		int escolhaUsuario = Integer.parseInt(opcaoUsuario);
		
		switch (escolhaUsuario) {
			
		   case 1: 
			   	adicionarCliente(con, SCHEMA);
			   	menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   	break;
		   case 2:
			    encontrarCliente(con, SCHEMA);
			    menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			    break;
		   case 3:
			   atualizarCliente(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 4:
			   deletarCliente(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 5:
			   listarClientes(con, SCHEMA);
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
			   break;
		   case 6:
			   menuNavegacaoPrincipal.menuPrincipal( con, SCHEMA);
		   default:
			   System.out.println("Opção inválida, digite novamente: ");
			   menuCliente( con, SCHEMA);
			}
	}
}
