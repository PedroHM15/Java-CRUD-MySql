package classes_login;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_cadastro.Tela_de_cadastro;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
//Login Frame Class
public class Tela_de_acesso extends JFrame {
	
	private JPanel jPane_Acesso;
	private JTextField nomeUsuario;
	private JPasswordField senhaFild;

	//Defining for this class to be the first to be executed
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_acesso frame = new Tela_de_acesso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_de_acesso() {
		setResizable(false);
		setForeground(new Color(0, 0, 0));
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		jPane_Acesso = new JPanel();
		jPane_Acesso.setBackground(Color.WHITE);
		jPane_Acesso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane_Acesso);
		jPane_Acesso.setLayout(null);
		
		JLabel LabelUsuario = new JLabel("Usuário:");
		LabelUsuario.setForeground(Color.BLACK);
		LabelUsuario.setBackground(Color.WHITE);
		LabelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		LabelUsuario.setBounds(64, 211, 133, 34);
		jPane_Acesso.add(LabelUsuario);
		
		JLabel LogoSenaiAcesso = new JLabel("");
		LogoSenaiAcesso.setVerticalAlignment(SwingConstants.TOP);
		LogoSenaiAcesso.setHorizontalAlignment(SwingConstants.LEFT);
		LogoSenaiAcesso.setBackground(new Color(0, 255, 255));
		LogoSenaiAcesso.setIcon(new ImageIcon("C:\\Users\\pdr08\\OneDrive\\Desktop\\Pedro\\ProjetoJavaCadastro\\LogoSenai.png"));
		LogoSenaiAcesso.setBounds(0, 0, 370, 135);
		jPane_Acesso.add(LogoSenaiAcesso);
		
		JLabel LabelSenha = new JLabel("Senha:");
		LabelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		LabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LabelSenha.setBackground(Color.WHITE);
		LabelSenha.setBounds(64, 312, 133, 35);
		jPane_Acesso.add(LabelSenha);
		
		nomeUsuario = new JTextField();
		nomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeUsuario.setColumns(10);
		nomeUsuario.setBackground(Color.WHITE);
		nomeUsuario.setBounds(190, 210, 380, 35);
		jPane_Acesso.add(nomeUsuario);
		
		senhaFild = new JPasswordField();
		senhaFild.setForeground(Color.BLACK);
		senhaFild.setBackground(Color.WHITE);
		senhaFild.setFont(new Font("Tahoma", Font.PLAIN, 20));
		senhaFild.setBounds(190, 312, 380, 35);
		jPane_Acesso.add(senhaFild);
		
		//Creating login button
		JButton btnEntrar = new JButton("Logar");
		btnEntrar.addActionListener(new ActionListener() {
			//Defining button action
			public void actionPerformed(ActionEvent e) {
				//running the login class
					Login.faz_login(nomeUsuario, senhaFild);
					//Closes the currently open frame
					dispose();				
			}
		});
		btnEntrar.setForeground(Color.GREEN);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(190, 424, 192, 59);
		jPane_Acesso.add(btnEntrar);
		
		//Creating button to register
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			//Defining button action
			public void actionPerformed(ActionEvent e) {
				//Executing the Tela_de_cadastro Frame
				Tela_de_cadastro Fcadastro = new Tela_de_cadastro();
				Fcadastro.show();
				//Closes the currently open frame
				dispose();

			}
		});
		btnCadastrar.setForeground(Color.RED);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(517, 424, 192, 59);
		jPane_Acesso.add(btnCadastrar);
	}
}