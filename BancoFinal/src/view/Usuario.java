package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Classes.CadastraCliente;
import Classes.CadastraGerente;
import Classes.Controlador;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Usuario {
	private JFrame frame;
	private static Controlador c = new Controlador();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario window = new Usuario();
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
	public Usuario() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Escolha um usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(83, 131, 267, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cliente");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuCliente back = new MenuCliente();
				frame.setVisible(false);
				back.main(null);
				
				
			}
		});
		btnNewButton.setBounds(112, 179, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGerente = new JButton("Gerente");
		btnGerente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuGerente back = new MenuGerente();
				frame.setVisible(false);
				back.main(null);
				
				
			}
		});
		btnGerente.setBounds(236, 179, 89, 23);
		frame.getContentPane().add(btnGerente);
		
		JLabel fundotela = new JLabel("New label");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/JGL_1.png"));
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}


}
