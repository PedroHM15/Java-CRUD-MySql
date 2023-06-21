package classes_cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_login.Tela_de_acesso;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//creating frame Tela_de_cadastro
public class Tela_de_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField NomeCadastro;
	private JTextField EmailCadastrar;
	private JTextField UsuarioCadastrar;
	private JPasswordField SenhaCadastrar;
	private JTextField IdadeCadastrar;
	private JTextField CpfCadastrar;

	public Tela_de_cadastro() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1050, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LogoSenaiCadastro = new JLabel("");
		LogoSenaiCadastro.setIcon(new ImageIcon("C:\\Users\\pdr08\\OneDrive\\Desktop\\Pedro\\ProjetoJavaCadastro\\LogoSenai.png"));
		LogoSenaiCadastro.setBounds(0, 0, 370, 135);
		panel.add(LogoSenaiCadastro);
		
		JLabel LNomeCadastrar = new JLabel("Nome:");
		LNomeCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		LNomeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LNomeCadastrar.setBackground(Color.WHITE);
		LNomeCadastrar.setBounds(25, 145, 89, 35);
		panel.add(LNomeCadastrar);
		
		NomeCadastro = new JTextField();
		NomeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NomeCadastro.setBackground(Color.WHITE);
		NomeCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		NomeCadastro.setBounds(111, 145, 260, 35);
		panel.add(NomeCadastro);
		NomeCadastro.setColumns(10);
		
		EmailCadastrar = new JTextField();
		EmailCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		EmailCadastrar.setColumns(10);
		EmailCadastrar.setBackground(Color.WHITE);
		EmailCadastrar.setBounds(111, 218, 260, 35);
		panel.add(EmailCadastrar);
		
		JLabel LEmailCadastrar = new JLabel("Email:");
		LEmailCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		LEmailCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LEmailCadastrar.setBackground(Color.WHITE);
		LEmailCadastrar.setBounds(25, 218, 89, 35);
		panel.add(LEmailCadastrar);
		
		UsuarioCadastrar = new JTextField();
		UsuarioCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsuarioCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		UsuarioCadastrar.setColumns(10);
		UsuarioCadastrar.setBackground(Color.WHITE);
		UsuarioCadastrar.setBounds(596, 145, 260, 35);
		panel.add(UsuarioCadastrar);
		
		JLabel LUsuarioCadastrar = new JLabel("Usuário:");
		LUsuarioCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		LUsuarioCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LUsuarioCadastrar.setBackground(Color.WHITE);
		LUsuarioCadastrar.setBounds(510, 145, 89, 35);
		panel.add(LUsuarioCadastrar);
		
		JLabel LSenhaCadastrar = new JLabel("Senha:");
		LSenhaCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		LSenhaCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LSenhaCadastrar.setBackground(Color.WHITE);
		LSenhaCadastrar.setBounds(510, 218, 89, 35);
		panel.add(LSenhaCadastrar);
		
		SenhaCadastrar = new JPasswordField();
		SenhaCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SenhaCadastrar.setBounds(596, 218, 260, 35);
		panel.add(SenhaCadastrar);
		//button to execute registration
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Executing the Cadastro class and sending all the necessary information to it
				Cadastro.faz_cadastro(UsuarioCadastrar, EmailCadastrar, NomeCadastro, SenhaCadastrar,IdadeCadastrar,CpfCadastrar);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(336, 394, 260, 100);
		panel.add(btnNewButton);
		
		JLabel LIdade = new JLabel("Idade:");
		LIdade.setHorizontalAlignment(SwingConstants.LEFT);
		LIdade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LIdade.setBackground(Color.WHITE);
		LIdade.setBounds(24, 293, 89, 35);
		panel.add(LIdade);
		
		IdadeCadastrar = new JTextField();
		IdadeCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		IdadeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IdadeCadastrar.setColumns(10);
		IdadeCadastrar.setBackground(Color.WHITE);
		IdadeCadastrar.setBounds(110, 293, 260, 35);
		panel.add(IdadeCadastrar);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setBounds(510, 293, 89, 35);
		panel.add(lblCpf);
		
		CpfCadastrar = new JTextField();
		CpfCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		CpfCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CpfCadastrar.setColumns(10);
		CpfCadastrar.setBackground(Color.WHITE);
		CpfCadastrar.setBounds(596, 293, 260, 35);
		panel.add(CpfCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			//Button to back Frame Tela_de_acesso
			public void actionPerformed(ActionEvent e) {
				Tela_de_acesso Facesso = new Tela_de_acesso();
				Facesso.show();
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(796, 433, 153, 69);
		panel.add(btnVoltar);
	}
}
