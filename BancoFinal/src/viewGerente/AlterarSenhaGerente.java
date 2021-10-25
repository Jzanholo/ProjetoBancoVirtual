package viewGerente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

import Classes.Controlador;
import view.TelaCliente;
import view.TelaGerente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarSenhaGerente {
	Controlador c = new Controlador();
	private JFrame frame;
	private JPasswordField txtsenha_atual;
	private JPasswordField txtsenha_nova;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenhaGerente window = new AlterarSenhaGerente();
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
	public AlterarSenhaGerente() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Alterar senha\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(20, 11, 185, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha atual:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 59, 95, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtsenha_atual = new JPasswordField();
		txtsenha_atual.setBounds(118, 59, 137, 20);
		frame.getContentPane().add(txtsenha_atual);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha nova:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(20, 95, 95, 23);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtsenha_nova = new JPasswordField();
		txtsenha_nova.setBounds(118, 97, 137, 20);
		frame.getContentPane().add(txtsenha_nova);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha_atual = new String(txtsenha_atual.getPassword());
				String senha_nova = new String(txtsenha_nova.getPassword());
						if(c.alterarSenhaGerente(senha_atual, senha_nova))
						{
							
							JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!");
							TelaGerente back = new TelaGerente();
							frame.setVisible(false);
							back.main(null);
						}
						else {
						JOptionPane.showMessageDialog(null,"Digite uma senha diferente da senha atual porfavor!");
						txtsenha_atual.setText("");
						txtsenha_nova.setText("");
						}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(20, 131, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
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
		
		JLabel fundotela = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}
}
