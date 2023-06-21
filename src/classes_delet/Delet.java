package classes_delet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes_de_conexao.Conexao;
import classes_dono.Tela_dono;

public class Delet {
	public static void faz_delet(String Usuario) {
		try {
			int resultado = 0;
			//Creating a database connection object	
			Connection con = Conexao.faz_conexao();
			//Creating a String variable to receive the SQL command
			String sql = "Delete from dados_senhas where usuario='"+Usuario+"'";
			//Creating an object that represents a precompiled SQL query that will be executed against a database.
			PreparedStatement stmt = con.prepareStatement(sql);
			
			/*Checks if the selected user is different from Owner, 
			 if it is equal to owner it will display a message that it cannot delete this user, 
			 if it is different run the command normally*/
			if(!Usuario.equals("Dono")) {
				resultado = stmt.executeUpdate();
				//checking if the query was executed
				if(resultado!=0) {
					//Shows message that user has been deleted
					JOptionPane.showMessageDialog(null, "Usuário Deletado");
					Tela_dono Fdono = new Tela_dono();
					Fdono.show();
				}
				else {
					//If the command is not executed, the message User not found will be displayed.
					JOptionPane.showMessageDialog(null,"Usuário não encontrado");
					Tela_delet Fdelet = new Tela_delet();
					Fdelet.show();
				}
				stmt.close();
				con.close();
				
			}
			else {
				//If user equals owner displays a message "This user cannot be deleted"
				JOptionPane.showMessageDialog(null, "Esse usuario não pode ser deletado");
				Tela_delet Fdelet = new Tela_delet();
				Fdelet.show();
			}
			stmt.close();
			con.close();
			
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
}
