package classes_dono;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_cadastro.Tela_de_cadastro;
import classes_delet.Tela_delet;
import classes_editar.Tela_de_edicao;
import classes_informacao.Tela_infoAll;
import classes_login.Tela_de_acesso;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
//Frame to user Dono
public class Tela_dono extends JFrame {

	private JPanel contentPane;
	String usuario = null;
	/**
	 * Create the frame.
	 */
	public Tela_dono() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Tela ADM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(400, 24, 219, 88);
		contentPane.add(lblNewLabel_1);
		
		
		//Button to open frame to delete users
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_delet Fdelet = new Tela_delet();				
				Fdelet.show();
				dispose();
			}
		});
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDeletar.setBounds(400, 426, 219, 88);
		contentPane.add(btnDeletar);
		
		//Button to open frame to edit users
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.WHITE);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_edicao Fedicao = new Tela_de_edicao();				
				Fedicao.show();
				dispose();
			}
		});
		btnEditar.setForeground(Color.BLUE);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditar.setBounds(400, 316, 219, 88);
		contentPane.add(btnEditar);
		
		//Button to open frame to register users
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_cadastro Fcadastro = new Tela_de_cadastro();
				Fcadastro.show();
				dispose();
			}
		});
		btnCadastrar.setForeground(Color.GREEN);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCadastrar.setBounds(400, 206, 219, 88);
		contentPane.add(btnCadastrar);
		
		//Button to back frame Tela_de_acesso
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
		
		//Button to open frame to take info users
		JButton btnInfo = new JButton("Informações");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_infoAll FinfoAll = new Tela_infoAll(usuario);
				FinfoAll.show();
				dispose();
			}
		});
		btnInfo.setForeground(Color.MAGENTA);
		btnInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnInfo.setBackground(Color.WHITE);
		btnInfo.setBounds(715, 206, 219, 88);
		contentPane.add(btnInfo);
	}
}
