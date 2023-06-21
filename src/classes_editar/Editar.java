package classes_editar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes_de_conexao.Conexao;
import classes_dono.Tela_dono;

public class Editar {
	public static void faz_edicao(String UsuarioEscolha, JTextField Usuario, JTextField Email, JTextField Nome, JTextField Senha,JTextField Idade,JTextField CPF) {
		try {
			int resultado=0;
			//Creating a database connection object	
			Connection con = Conexao.faz_conexao();
			//Creating a String variable to receive the SQL command
			String sql = "UPDATE dados_senhas SET usuario=?,senha=?,nome=?,idade=?,cpf=?,email=? where usuario=?";
			//Creating an object that represents a precompiled SQL query that will be executed against a database.
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,(Usuario.getText()));
			stmt.setString(2, new String (Senha.getText()));
			stmt.setString(3,(Nome.getText()));
			stmt.setString(4,(Idade.getText()));
			stmt.setString(5,(CPF.getText()));
			stmt.setString(6,(Email.getText()));
			stmt.setString(7,(UsuarioEscolha));
			//Variable that receives the result of stmt
			resultado = stmt.executeUpdate();
			
			//checking if the query was executed
			if(resultado!=0) {
				//Shows update completed message
				JOptionPane.showMessageDialog(null, "Usuário Atualizado");
				Tela_dono Fdono = new Tela_dono();
				Fdono.show();
			}
			//If something goes wrong, an error message will be displayed.
			else {
				JOptionPane.showMessageDialog(null,"O usuário não foi encontrado ou você digitou Usuário//Email ja existente");
				Tela_de_edicao Fedicao = new Tela_de_edicao();
				Fedicao.show();
			}
			stmt.close();
			con.close();
			
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
		
		
	}

	
	
}