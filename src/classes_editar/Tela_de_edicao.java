package classes_editar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_de_conexao.Conexao;
import classes_dono.Tela_dono;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

//creating frame Tela_de_edicao
public class Tela_de_edicao extends JFrame {

	private JPanel contentPane;
	private JTextField NomeEditar;
	private JTextField UsuarioEditar;
	private JTextField EmailEditar;
	private JPasswordField SenhaEditar;
	private JTextField IdadeEditar;
	private JTextField CpfEditar;
	private String selecionado;

	/**
	 * Create the frame.
	 */
	public Tela_de_edicao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Informe o Usuário de quem deseja fazer a Edição");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(45, 102, 529, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pdr08\\OneDrive\\Desktop\\Pedro\\ProjetoJavaCadastro\\LogoSenai.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 370, 135);
		contentPane.add(lblNewLabel);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.CENTER);
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbNome.setBounds(69, 233, 106, 30);
		contentPane.add(lbNome);
		
		NomeEditar = new JTextField();
		NomeEditar.setHorizontalAlignment(SwingConstants.LEFT);
		NomeEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NomeEditar.setColumns(10);
		NomeEditar.setBounds(168, 233, 290, 30);
		contentPane.add(NomeEditar);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbSenha.setBounds(69, 301, 106, 30);
		contentPane.add(lbSenha);
		
		UsuarioEditar = new JTextField();
		UsuarioEditar.setHorizontalAlignment(SwingConstants.LEFT);
		UsuarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsuarioEditar.setColumns(10);
		UsuarioEditar.setBounds(625, 233, 290, 30);
		contentPane.add(UsuarioEditar);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbUsuario.setBounds(526, 233, 106, 30);
		contentPane.add(lbUsuario);
		
		EmailEditar = new JTextField();
		EmailEditar.setHorizontalAlignment(SwingConstants.LEFT);
		EmailEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailEditar.setColumns(10);
		EmailEditar.setBounds(625, 301, 290, 30);
		contentPane.add(EmailEditar);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbEmail.setBounds(526, 301, 106, 30);
		contentPane.add(lbEmail);
		
		SenhaEditar = new JPasswordField();
		SenhaEditar.setHorizontalAlignment(SwingConstants.LEFT);
		SenhaEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SenhaEditar.setBounds(168, 301, 290, 30);
		contentPane.add(SenhaEditar);
		
		JLabel lbUsuario_1 = new JLabel("Usuário:");
		lbUsuario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbUsuario_1.setBounds(69, 154, 106, 30);
		contentPane.add(lbUsuario_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Informe as modificações desejadas");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(45, 187, 529, 55);
		contentPane.add(lblNewLabel_1_1);
		
		/*As in the Owner's information screen, 
		there is also a JComboBox that receives all users registered in the database.*/
		JComboBox<String> cbSelect = new JComboBox<String>();
		cbSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSelect.setBackground(Color.WHITE);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = Conexao.faz_conexao();
			String sql="Select * from dados_senhas";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			cbSelect.removeAll();
			//Adding usernames to the JComboBox
			while(rs.next()) {
				
				cbSelect.addItem(rs.getString("usuario"));
			}
			
		} catch (Exception e) {
			
		}
		cbSelect.setBounds(168, 158, 290, 30);
		contentPane.add(cbSelect);
		
		//confirmation button
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//selecionado variable receives the currently selected user in the combobox
				selecionado = (String) cbSelect.getSelectedItem();
				/*Sends to the Edit class the name of the selected 
				user and all the information placed in the JTextFilds*/
				Editar.faz_edicao(selecionado, UsuarioEditar, EmailEditar, NomeEditar, SenhaEditar,IdadeEditar,CpfEditar);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(418, 453, 215, 69);
		contentPane.add(btnNewButton);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdade.setBounds(69, 378, 106, 30);
		contentPane.add(lblIdade);
		
		IdadeEditar = new JTextField();
		IdadeEditar.setHorizontalAlignment(SwingConstants.LEFT);
		IdadeEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IdadeEditar.setColumns(10);
		IdadeEditar.setBounds(168, 378, 290, 30);
		contentPane.add(IdadeEditar);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lbCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCpf.setBounds(526, 378, 106, 30);
		contentPane.add(lbCpf);
		
		CpfEditar = new JTextField();
		CpfEditar.setHorizontalAlignment(SwingConstants.LEFT);
		CpfEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CpfEditar.setColumns(10);
		CpfEditar.setBounds(625, 378, 290, 30);
		contentPane.add(CpfEditar);
		
		//Button to back Frame Dono
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_dono Fdono = new Tela_dono();
				Fdono.show();
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(796, 433, 153, 69);
		contentPane.add(btnVoltar);
		
	}

}
