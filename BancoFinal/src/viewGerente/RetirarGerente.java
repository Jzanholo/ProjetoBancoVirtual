package viewGerente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import Classes.Acoes;
import Classes.Controlador;
import view.TelaCliente;
import view.TelaGerente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetirarGerente {
	Controlador c = new Controlador();
	Acoes A = new Acoes();
	private JFrame frame;
	private JTextField txtnumero;
	private JTextField txtretira;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetirarGerente window = new RetirarGerente();
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
	public RetirarGerente() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Retirar dos clientes");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 10, 393, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero da conta: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 58, 132, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtnumero = new JTextField();
		txtnumero.setColumns(10);
		txtnumero.setBounds(148, 60, 99, 20);
		frame.getContentPane().add(txtnumero);
		
		JLabel lblNewLabel_3 = new JLabel("Quanto deseja retirar?");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 92, 169, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtretira = new JTextField();
		txtretira.setColumns(10);
		txtretira.setBounds(20, 120, 99, 20);
		frame.getContentPane().add(txtretira);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int retorno=0;
				String numero_conta = txtnumero.getText();
				
				if(c.verificaCaracter(numero_conta))
				{
					
					if(c.isInteger(txtretira.getText()))
					{
						
						int n = Integer.parseInt(txtnumero.getText());
						float valor_retirar =Float.parseFloat(txtretira.getText());
								if(valor_retirar>110000) {
								retorno=c.retirarSaldoGerente(n, valor_retirar);
								
								if(retorno==1)
								{
								JOptionPane.showMessageDialog(null,"Dinheiro retirado!");
								
								A.setExtrato("Gerente retirou");
								A.setNmr(n);
								A.setValor(valor_retirar);
								c.adicionarExtrato(A);
								
								TelaGerente back = new TelaGerente();
								frame.setVisible(false);
								back.main(null);

								}
								else if(retorno==2)
								{
									txtnumero.setText("");
									txtretira.setText("");
									JOptionPane.showMessageDialog(null,"Seu saldo não pode ficar negativo!");

								}
							
								else if(retorno==3)
								{
									txtnumero.setText("");
									txtretira.setText("");
									JOptionPane.showMessageDialog(null,"Número da conta não existe!");
								}
								}
								else {
									txtnumero.setText("");
									txtretira.setText("");
									JOptionPane.showMessageDialog(null,"Retire apenas valores maiores que R$110.000,00!");
								}
					}
					else {
						txtnumero.setText("");
						txtretira.setText("");
						JOptionPane.showMessageDialog(null,"Valor inválido!");
					}
				
			}
			}
		});
		btnRetirar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRetirar.setBounds(20, 153, 89, 23);
		frame.getContentPane().add(btnRetirar);
		
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
