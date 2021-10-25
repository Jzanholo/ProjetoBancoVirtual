package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;

import Classes.CadastraCliente;
import Classes.CadastraGerente;
import Classes.Controlador;
import Classes.Menu;

import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
public class MenuGerente {
	Controlador c = new Controlador();
	private JFrame frmBanco;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGerente window = new MenuGerente();
					window.frmBanco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuGerente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBanco = new JFrame();
		frmBanco.setTitle("\r\n");
		frmBanco.getContentPane().setBackground(Color.WHITE);
		frmBanco.setBounds(100, 100, 440, 300);
		frmBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBanco.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(113, 169, 46, 14);
		frmBanco.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(113, 199, 46, 14);
		frmBanco.getContentPane().add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setBounds(169, 168, 137, 20);
		frmBanco.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		
		
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(169, 198, 137, 20);
		frmBanco.getContentPane().add(txtSenha);

		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtLogin.getText();
				String senha = new String(txtSenha.getPassword());
				try {
					if(c.readGerente(nome, senha)) {
						c.setUsando(nome);
						JOptionPane.showMessageDialog(null, "Bem vindo "+nome+"!");
						TelaGerente proximo = new TelaGerente();
						frmBanco.setVisible(false);
						proximo.main(null);
					}

						else 
						{
							txtLogin.setText("");
							txtSenha.setText("");
							JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
						}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			};
		});
		btnNewButton.setBounds(179, 229, 89, 23);
		frmBanco.getContentPane().add(btnNewButton);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/JGL_1.png"));
		
		JLabel lblNewLabel_2 = new JLabel("Gerente");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(179, 133, 82, 29);
		frmBanco.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu back = new Menu();
				frmBanco.setVisible(false);
				back.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 229, 89, 23);
		frmBanco.getContentPane().add(btnNewButton_1);
		
		

		


		
		JLabel fundomenu = new JLabel("New label");
		fundomenu.setIcon(img);
		fundomenu.setBounds(0, 0, 424, 261);
		frmBanco.getContentPane().add(fundomenu);
		


	}
	

}
