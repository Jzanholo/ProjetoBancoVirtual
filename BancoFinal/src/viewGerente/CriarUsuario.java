package viewGerente;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.TelaCliente;
import view.TelaGerente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Classes.CadastraCliente;
import Classes.CadastraGerente;
import Classes.Controlador;
import Classes.Menu;

import javax.swing.JPasswordField;

public class CriarUsuario {
	Controlador c = new Controlador();
	CadastraCliente cc = new CadastraCliente();
	CadastraGerente cg = new CadastraGerente();	
	private JFrame frame;
	private JTextField txtnome;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarUsuario window = new CriarUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CriarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox txtcombo = new JComboBox();
		txtcombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtcombo.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Gerente"}));
		txtcombo.setBounds(21, 95, 89, 22);
		frame.getContentPane().add(txtcombo);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente back = new TelaGerente();
				frame.setVisible(false);
				back.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(20, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtnome.getText();
				String senha = new String(txtsenha.getPassword());
				String escolha = (String)txtcombo.getSelectedItem();
				if(escolha.equals("Cliente")){
					if(c.existeCliente(nome)) {
					cc.setLogin(nome);
					cc.setSenha(senha);
					cc.setNome_gerente(c.getUsando());
					cc.setTipo_conta(escolha);
					c.adicionarCliente(cc);
					try {
						c.writeCliente();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Conta cliente foi criada!");
					TelaGerente back = new TelaGerente();
					frame.setVisible(false);
					back.main(null);
					}
					else {
						txtnome.setText("");
						txtsenha.setText("");

						JOptionPane.showMessageDialog(null,"Usuário já cadastrado!");
						
					}
				}
				else 
				{
					if(c.existeGerente(nome)) {
					cg.setLogin(nome);
					cg.setSenha(senha);
					c.adicionarGerente(cg);
					
						
							try {
								c.writeGerente();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
					
					JOptionPane.showMessageDialog(null,"Conta gerente foi criada!");
					TelaGerente back = new TelaGerente();
					frame.setVisible(false);
					back.main(null);
					}
					else {
						txtnome.setText("");
						txtsenha.setText("");
	
						JOptionPane.showMessageDialog(null,"Usuário já cadastrado!");
					}
				}
			}
		});
		btnCriar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCriar.setBounds(325, 227, 89, 23);
		frame.getContentPane().add(btnCriar);
		
		JLabel lblNewLabel_1 = new JLabel("Criar novo usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 10, 310, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Qual tipo de usu\u00E1rio gostaria de criar?");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(21, 58, 279, 14);
		frame.getContentPane().add(lblNewLabel_2);
		

		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		JLabel lblNewLabel_2_1 = new JLabel("Digite o nome do usu\u00E1rio:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(20, 141, 180, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtnome = new JTextField();
		txtnome.setBounds(201, 139, 129, 20);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Digite uma senha para o usu\u00E1rio: ");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(20, 171, 234, 14);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(256, 169, 129, 20);
		frame.getContentPane().add(txtsenha);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(img);
		fundo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundo);
	}
}
