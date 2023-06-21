package classes_informacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

import classes_de_conexao.Conexao;
import classes_dono.Tela_dono;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
//Information frame for the Dono user to see all the information of other users
public class Tela_infoAll extends JFrame {

	private static JPanel contentPane;
	private static String selecionado;
	
	 String PegarIdade=null;
	 String PegarCPF=null;
	 String PegarNome=null;
	 String PegarEmail=null;
	 String PegarSenha=null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		
	/**
	 * Create the frame.
	 */
	public Tela_infoAll(String usuario) {
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
		
		//Creating a JComboBox that will receive all usernames registered in the database
		JComboBox<String> cbInfo = new JComboBox<String>();
		cbInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbInfo.setBackground(Color.WHITE);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = Conexao.faz_conexao();
			String sql="Select * from dados_senhas";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			cbInfo.removeAll();
			//Adding usernames to the JComboBox
			while(rs.next()) {
				
				cbInfo.addItem(rs.getString("usuario"));
			}
			
		} catch (Exception e) {
			
		}
		cbInfo.setBounds(129, 145, 355, 30);
		contentPane.add(cbInfo);
		
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(10, 145, 98, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(10, 210, 98, 30);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIdade.setBackground(Color.WHITE);
		lblIdade.setBounds(10, 271, 98, 30);
		contentPane.add(lblIdade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setBounds(10, 331, 98, 30);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setBounds(10, 396, 98, 30);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(10, 468, 98, 30);
		contentPane.add(lblEmail);
		
		
		//Button to get user information
		JButton btnPegar = new JButton("Pegar");
		btnPegar.setBackground(Color.WHITE);
		btnPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				//The user selected in Jcombobox will display all information
				selecionado = (String) cbInfo.getSelectedItem();
				Tela_infoAll FinfoAll = new Tela_infoAll(selecionado);
				FinfoAll.show();
				dispose();
			}
		});
	
		
		btnPegar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPegar.setBounds(509, 145, 127, 30);
		contentPane.add(btnPegar);
	
		
		try {
			Connection con = Conexao.faz_conexao();
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery("Select * from dados_senhas where usuario='"+usuario+"'");
			while(rs1.next()) {
				PegarNome = rs1.getString("nome");
				PegarEmail = rs1.getString("email");
				PegarSenha = rs1.getString("senha");
				PegarIdade = rs1.getString("idade");
				PegarCPF = rs1.getString("cpf");
				
			}
			
			
			
		} catch (Exception e1) {
			
		}
		
		JLabel lblNomeInfo = new JLabel(PegarNome);
		lblNomeInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNomeInfo.setBounds(118, 210, 463, 30);
		contentPane.add(lblNomeInfo);
		
		JLabel lblIdadeInfo = new JLabel(PegarIdade);
		lblIdadeInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIdadeInfo.setBounds(118, 271, 463, 30);
		contentPane.add(lblIdadeInfo);
		
		JLabel lblCpfInfo = new JLabel(PegarCPF);
		lblCpfInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpfInfo.setBounds(118, 331, 463, 30);
		contentPane.add(lblCpfInfo);
		
		JLabel lblSenhaInfo = new JLabel(PegarSenha);
		lblSenhaInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenhaInfo.setBounds(118, 396, 463, 30);
		contentPane.add(lblSenhaInfo);
		
		JLabel lblEmailInfo = new JLabel(PegarEmail);
		lblEmailInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmailInfo.setBounds(118, 468, 463, 30);
		contentPane.add(lblEmailInfo);
		
		//Button to back Tela_dono
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_dono Fdono = new Tela_dono();
				Fdono.show();
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(783, 479, 153, 69);
		contentPane.add(btnVoltar);
		
		
	}	
}
		
	

