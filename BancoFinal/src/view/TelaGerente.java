package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import viewGerente.AlterarSenhaGerente;
import viewGerente.AplicaCliente;
import viewGerente.CadastraEdita;
import viewGerente.CriarUsuario;
import viewGerente.RetirarGerente;
import viewGerente.TransferenciaClientes;
import viewGerente.VerificarInformacoesContas;
import viewGerente.VerificarNomeCliente;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGerente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente window = new TelaGerente();
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
	public TelaGerente() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Gerente");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(160, 10, 113, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton b1 = new JButton("Verificar o nome e contas de seus clientes");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarNomeCliente b1 = new VerificarNomeCliente();
				frame.setVisible(false);
				b1.main(null);
			}
		});
		b1.setFont(new Font("Arial", Font.PLAIN, 12));
		b1.setBounds(57, 58, 320, 23);
		frame.getContentPane().add(b1);
		
		JButton b5 = new JButton("Retiradas");
		b5.setFont(new Font("Arial", Font.PLAIN, 12));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetirarGerente b5 = new RetirarGerente();
				frame.setVisible(false);
				b5.main(null);
			}
		});
		b5.setBounds(57, 194, 155, 23);
		frame.getContentPane().add(b5);
		
		JButton b3 = new JButton("Aplicar dinheiro");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicaCliente b3 = new AplicaCliente();
				frame.setVisible(false);
				b3.main(null);
			}
		});
		b3.setFont(new Font("Arial", Font.PLAIN, 12));
		b3.setBounds(57, 126, 155, 23);
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("Transfer\u00EAncia");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferenciaClientes b4 = new TransferenciaClientes();
				frame.setVisible(false);
				b4.main(null);
				
			}
		});
		b4.setFont(new Font("Arial", Font.PLAIN, 12));
		b4.setBounds(57, 160, 155, 23);
		frame.getContentPane().add(b4);
		
		JButton b7 = new JButton("Alterar senha");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarSenhaGerente b7 = new AlterarSenhaGerente();
				frame.setVisible(false);
				b7.main(null);
			}
		});
		b7.setFont(new Font("Arial", Font.PLAIN, 12));
		b7.setBounds(222, 160, 155, 23);
		frame.getContentPane().add(b7);
		
		JButton b2 = new JButton("Verificar as informa\u00E7\u00F5es de cada uma das contas");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarInformacoesContas b2 = new VerificarInformacoesContas();
				frame.setVisible(false);
				b2.main(null);
			}
		});
		b2.setFont(new Font("Arial", Font.PLAIN, 12));
		b2.setBounds(57, 92, 320, 23);
		frame.getContentPane().add(b2);
		
		JButton b6 = new JButton("Cadastra/Edita limites");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastraEdita b6 = new CadastraEdita();
				frame.setVisible(false);
				b6.main(null);
			}
		});
		b6.setFont(new Font("Arial", Font.PLAIN, 12));
		b6.setBounds(222, 126, 155, 23);
		frame.getContentPane().add(b6);
		
		JButton b8 = new JButton("Criar novo usu\u00E1rio");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarUsuario b8 = new CriarUsuario();
				frame.setVisible(false);
				b8.main(null);
			}
		});
		b8.setFont(new Font("Arial", Font.PLAIN, 12));
		b8.setBounds(222, 194, 155, 23);
		frame.getContentPane().add(b8);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGerente back = new MenuGerente();
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
