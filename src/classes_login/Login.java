package classes_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes_de_conexao.Conexao;
import classes_dono.Tela_dono;
import classes_informacao.Tela_informacoes;


public class Login {
	public static void faz_login(JTextField usuarioLogin,JTextField senhaLogin) {
		
		try {
			//Creating a database connection object
			Connection con = Conexao.faz_conexao();
			//Creating a String variable to receive the SQL command
			String sql = "select * from dados_senhas where usuario=? and senha=?";
			//Creating an object that represents a precompiled SQL query that will be executed against a database.
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, usuarioLogin.getText());
			stmt.setString(2, new String(senhaLogin.getText()));	
			//Object that receives the result of stmt
			ResultSet resultado = stmt.executeQuery();
			
			String usuarioL = new String(usuarioLogin.getText());
			//checking if the query was executed
			if(resultado.next()){
				//checking if the user is Owner, if it is, it will execute the Tela_dono frame
				switch(usuarioL) {
				case "Dono":						
						Tela_dono Fdono = new Tela_dono();
						Fdono.show();
					
					
					break;
				//If the user is not the owner, the Tela_informacoes Frame will open
				default:
					Tela_informacoes Finformacoes = new Tela_informacoes(usuarioLogin.getText());
					Finformacoes.show();
					break;
					
				}
				
			}
			/*
			If the username or password is wrong, 
			a message will be displayed, and the Tela_de_acesso Frame will be opened again*/
			else {
				JOptionPane.showMessageDialog(null,"Usuário/Senha Incorreto(s)");
				Tela_de_acesso Facesso = new Tela_de_acesso();
				Facesso.show();
			}
			
			stmt.close();
			con.close();
			
			
		} catch (SQLException e1) {
				
			e1.printStackTrace();
		}
	}
}