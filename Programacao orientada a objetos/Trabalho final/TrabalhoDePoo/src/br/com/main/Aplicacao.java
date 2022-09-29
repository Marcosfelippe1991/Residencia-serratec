package br.com.main;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.MenuNavegacao.*;
import br.com.conexao.Conexao;

public class Aplicacao {
	
	public static Scanner input = new Scanner(System.in);
	public static final String BD = "trabalhopoo";
	public static final String SCHEMA = "vendas";

	public static void main(String[] args) {
		
		Conexao con = new Conexao("PostgreSql", "localhost", "5432", "trabalhopoo", "postgres", "Mfa2019@");
		con.conect();
		
		MenuNavegacaoPrincipal menuNavegacaoPrincipal = new MenuNavegacaoPrincipal();
		
		JOptionPane.showMessageDialog(null, menuNavegacaoPrincipal.inserirCabecalho(), "Bem vindo !", JOptionPane.INFORMATION_MESSAGE);
		
		menuNavegacaoPrincipal.menuPrincipal(con, SCHEMA);
		
		con.disconect();
	}
}

