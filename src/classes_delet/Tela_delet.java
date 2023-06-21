package classes_delet;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
//creating frame Tela_delet
public class Tela_delet extends JFrame {

	private JPanel contentPane;
	private String aux;

	/**
	 * Create the frame.
	 */
	public Tela_delet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pdr08\\OneDrive\\Desktop\\Pedro\\ProjetoJavaCadastro\\LogoSenai.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 370, 135);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe o Usuário de quem deseja DELETAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(75, 145, 874, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbUsuario_1 = new JLabel("Usuário:");
		lbUsuario_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbUsuario_1.setBounds(179, 297, 165, 41);
		contentPane.add(lbUsuario_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tela ADM");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(364, 23, 219, 88);
		contentPane.add(lblNewLabel_1_1);
		
		/*As in the Owner's information screen, 
		there is also a JComboBox that receives all users registered in the database.*/
		JComboBox<String> cbDelet = new JComboBox<String>();
		cbDelet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbDelet.setBackground(Color.WHITE);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = Conexao.faz_conexao();
			String sql="Select * from dados_senhas";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			cbDelet.removeAll();
			//Adding usernames to the JComboBox
			while(rs.next()) {
				
				cbDelet.addItem(rs.getString("usuario"));
			}
			
		} catch (Exception e) {
			
		}
		cbDelet.setBounds(358, 297, 370, 41);
		contentPane.add(cbDelet);
		
		//delete button
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aux variable receives the currently selected user in the combobox
				aux = (String) cbDelet.getSelectedItem();
				//Sends the name of the selected user to the Delete class
				Delet.faz_delet(aux);
				dispose();
			}
		});
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDeletar.setBounds(376, 414, 219, 88);
		contentPane.add(btnDeletar);
		
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
