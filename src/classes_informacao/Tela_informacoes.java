package classes_informacao;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import classes_de_conexao.Conexao;
import classes_login.Tela_de_acesso;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tela_informacoes extends JFrame {
	
	
	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public Tela_informacoes(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pdr08\\OneDrive\\Desktop\\Pedro\\ProjetoJavaCadastro\\LogoSenai.png"));
		lblNewLabel.setBounds(0, 0, 370, 135);
		contentPane.add(lblNewLabel);				
		
		JLabel lblInfo = new JLabel("Informações: ");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInfo.setBounds(26, 145, 162, 37);
		contentPane.add(lblInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(198, 145, 120, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(198, 302, 120, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Usuário:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(198, 349, 120, 37);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Senha:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(198, 413, 120, 37);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Idade:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(198, 200, 120, 37);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("CPF:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(198, 255, 120, 37);
		contentPane.add(lblNewLabel_1_5);
		
	
		//Creating variables that will receive user information to be placed in the Jlabel
		String PegarUsuario=null;
		String PegarIdade=null;
		String PegarCPF=null;
		String PegarNome=null;
		String PegarEmail=null;
		String PegarSenha=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = Conexao.faz_conexao();
			stmt=con.createStatement();
			//Executing command with the user who is currently logged in
			rs=stmt.executeQuery("Select * from dados_senhas where usuario='"+usuario+"'");
			//While to put each information received by rs in its respective variable
			while(rs.next()) {
				PegarUsuario = rs.getString("usuario");
				PegarNome = rs.getString("nome");
				PegarEmail = rs.getString("email");
				PegarSenha = rs.getString("senha");
				PegarIdade = rs.getString("idade");
				PegarCPF = rs.getString("cpf");
				
			}
			
			
			
		} catch (Exception e) {
			
		}
		
		//Setting the variables in the JLabel
		JLabel lblNome = new JLabel(PegarNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(294, 145, 463, 37);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel(PegarEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(294, 302, 463, 37);
		contentPane.add(lblEmail);
		
		JLabel lblUsuario = new JLabel(PegarUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(294, 349, 463, 37);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel(PegarSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenha.setBounds(294, 413, 463, 37);
		contentPane.add(lblSenha);
		
		JLabel lblCPF = new JLabel(PegarCPF);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCPF.setBounds(294, 255, 463, 37);
		contentPane.add(lblCPF);
		
		JLabel lblIdade = new JLabel(PegarIdade);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIdade.setBounds(294, 200, 463, 37);
		contentPane.add(lblIdade);
		
		//Button to back Tela_de_acesso
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_de_acesso Facesso = new Tela_de_acesso();
				Facesso.show();
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(796, 433, 153, 69);
		contentPane.add(btnVoltar);
	}
}
