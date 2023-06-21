package classes_cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes_de_conexao.Conexao;
import classes_login.Tela_de_acesso;

public class Cadastro {
	public static void faz_cadastro(JTextField usuarioCadastro, JTextField emailCadastro, JTextField nomeCadastro, JTextField senhaCadastro, JTextField IdadeCadastro, JTextField CpfCadastro) {
		
		try {
			int resultado=0;
			//Creating a database connection object	
			Connection con = Conexao.faz_conexao();
			//Creating a String variable to receive the SQL command
			String sql = "insert into dados_senhas (usuario,senha,nome, idade,cpf, email) values (?,?,?,?,?,?)";
			//Creating an object that represents a precompiled SQL query that will be executed against a database.
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,(usuarioCadastro.getText()));
			stmt.setString(2, new String (senhaCadastro.getText()));
			stmt.setString(3,(nomeCadastro.getText()));
			stmt.setString(4,(IdadeCadastro.getText()));
			stmt.setString(5,(CpfCadastro.getText()));
			stmt.setString(6,(emailCadastro.getText()));
			//Variable that receives the result of stmt
			resultado = stmt.executeUpdate();
			
			
			//checking if the query was executed
			if(resultado!=0) {
				//Shows registration completed message
				JOptionPane.showMessageDialog(null, "Novo Usuário Cadastrado");
				Tela_de_acesso Facesso = new Tela_de_acesso();
				Facesso.show();
				
				
			}
			//If something goes wrong, an error message will be displayed.
			else {
				JOptionPane.showMessageDialog(null,"Algo deu errado");
			}
			
			stmt.close();
			con.close();
			
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null,"Algo deu errado: "+e2);
			Tela_de_cadastro Fcadastro = new Tela_de_cadastro();
			Fcadastro.show();
			
			
		}
		
	}

	
	
}
