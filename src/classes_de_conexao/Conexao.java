package classes_de_conexao;

import java.sql.*;


//Class to create database connection
public class Conexao {
	//Creating variables to facilitate future modifications of user, path or password
	private static String caminhoSQL = "jdbc:mysql://localhost:3306/db_Cadastro";
	private static String usuarioSQL = "root";
	private static String senhaSQL = "";
	//Creating Database Connection
	public static Connection faz_conexao() throws SQLException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(caminhoSQL,usuarioSQL,senhaSQL);
		
		
		}catch(ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
			
		}
	}
}
