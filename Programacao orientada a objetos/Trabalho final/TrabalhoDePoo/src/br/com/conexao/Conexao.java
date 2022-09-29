package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por realizar a conexão com o banco de dados. 
 * @author Marcos Felippe de Araujo, Rodrigo Lisboa Alves, Rodolfo Carius Souza de Oliveira,
 * Rafael Felipe dos Santos Rodrigues, Diego Aristides da Silva.
 *
 */
public class Conexao {
	private String local;
	private String user;
	private String senha;
	private Connection c;
	private Statement statment;
	private String str_conexao;
	private String driverjdbc;
	
	/**
	 * Método por realizar conexão com o banco de dados.
	 * @param bd - Banco de dados.
	 * @param local	- Local que roda o banco.
	 * @param porta	- Porta que roda o banco.
	 * @param banco	- Banco de dados.
	 * @param user - usuario para login.
	 * @param senha - senha de login.
	 */
	public Conexao(String bd, String local, String porta,
			String banco, String user, String senha) {
		if (bd.equals("PostgreSql")){
			setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
  			setLocal(local);
  			setSenha(senha);
  			setUser(user);
  			setDriverjdbc("org.postgresql.Driver");
		}
	}
	
	/**
	 *  Método responsável por configurar o acesso de usúario.
	 * @param user - Usuario.
	 * @param senha - Senha.
	 */
	public void configUser(String user, String senha) {
		setUser(user);
		setSenha(senha);
	}
	
	/*
	 * Método responsável por configurar o banco local.
	 * @param banco - Banco de dados.
	 */
	public void configLocal(String banco) {
		setLocal(banco);
	}
	
	 /**
	  * Método responsável pela conexão com o banco.
	  */
	public void conect(){
		try {
			Class.forName(getDriverjdbc());
			setC(DriverManager.getConnection(getStr_conexao(), getUser(), getSenha()));
			//setStatment(getC().createStatement());
			setStatment(getC().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE));
		}catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por desconectar o banco.
	 */
	public void disconect(){
		try {
			getC().close();
		}catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}
	
	/*
	 * Método responsavel por criar a Query de conexão.
	 * @param query - Query de conexão.
	 */
	public ResultSet query(String query){
		try {
			return getStatment().executeQuery(query);
		}catch (SQLException ex) {
			if (!ex.getLocalizedMessage().contentEquals("Nenhum resultado foi retornado pela consulta.")) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
			return null;
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public Statement getStatment() {
		return statment;
	}

	public void setStatment(Statement statment) {
		this.statment = statment;
	}

	public String getStr_conexao() {
		return str_conexao;
	}

	public void setStr_conexao(String str_conexao) {
		this.str_conexao = str_conexao;
	}

	public String getDriverjdbc() {
		return driverjdbc;
	}

	public void setDriverjdbc(String driverjdbc) {
		this.driverjdbc = driverjdbc;
	}
}
