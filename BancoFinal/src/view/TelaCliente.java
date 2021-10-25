package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import viewCliente.AbrirConta;
import viewCliente.AlterarSenha;
import viewCliente.AplicarDinheiro;
import viewCliente.RetirarDinheiro;
import viewCliente.VerificarExtrato;
import viewCliente.VerificarSaldo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
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
	public TelaCliente() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(170, 11, 92, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton botao1 = new JButton("Abrir conta");
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirConta b1 = new AbrirConta();
				frame.setVisible(false);
				b1.main(null);
			}
		});
		botao1.setForeground(Color.BLACK);
		botao1.setFont(new Font("Arial", Font.PLAIN, 12));
		botao1.setBounds(93, 58, 119, 23);
		frame.getContentPane().add(botao1);
		
		JButton botao2 = new JButton("Aplicar dinheiro");
		botao2.setFont(new Font("Arial", Font.PLAIN, 12));
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicarDinheiro b2 = new AplicarDinheiro();
				frame.setVisible(false);
				b2.main(null);
			}
		});
		botao2.setBounds(93, 92, 119, 23);
		frame.getContentPane().add(botao2);
		
		JButton botao3 = new JButton("Retirar dinheiro");
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetirarDinheiro b3 = new RetirarDinheiro();
				frame.setVisible(false);
				b3.main(null);
			}
		});
		botao3.setFont(new Font("Arial", Font.PLAIN, 12));
		botao3.setBounds(93, 126, 119, 23);
		frame.getContentPane().add(botao3);
		
		JButton botao5 = new JButton("Verificar \r\nextrato");
		botao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarExtrato b5 = new VerificarExtrato();
				frame.setVisible(false);
				b5.main(null);
			}
		});
		botao5.setFont(new Font("Arial", Font.PLAIN, 12));
		botao5.setBounds(222, 92, 119, 23);
		frame.getContentPane().add(botao5);
		
		JButton botao6 = new JButton("Alterar senha");
		botao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarSenha b6 = new AlterarSenha();
				frame.setVisible(false);
				b6.main(null);
			}
		});
		botao6.setFont(new Font("Arial", Font.PLAIN, 12));
		botao6.setBounds(222, 126, 119, 23);
		frame.getContentPane().add(botao6);
		
		JButton botao4 = new JButton("Verificar saldo");
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarSaldo b4 = new VerificarSaldo();
				frame.setVisible(false);
				b4.main(null);
			}
		});
		botao4.setFont(new Font("Arial", Font.PLAIN, 12));
		botao4.setBounds(222, 58, 119, 23);
		frame.getContentPane().add(botao4);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente back = new MenuCliente();
				frame.setVisible(false);
				back.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		

		
		JLabel fundotela = new JLabel("");
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}
}
