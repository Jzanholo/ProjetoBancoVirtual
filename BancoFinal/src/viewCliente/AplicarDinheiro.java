package viewCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Classes.Acoes;
import Classes.Controlador;
import Classes.Poupanca;
import view.TelaCliente;

import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AplicarDinheiro {
	Controlador c = new Controlador();
	Acoes A = new Acoes();
	private JFrame frame;
	private JTextField txtnumero;
	private JTextField txtaplicar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicarDinheiro window = new AplicarDinheiro();
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
	public AplicarDinheiro() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Aplicar dinheiro na conta");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(20, 10, 404, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero da conta: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 58, 132, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtnumero = new JTextField();
		txtnumero.setBounds(148, 60, 99, 20);
		frame.getContentPane().add(txtnumero);
		txtnumero.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quanto deseja aplicar?");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 92, 169, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtaplicar = new JTextField();
		txtaplicar.setBounds(20, 120, 86, 20);
		frame.getContentPane().add(txtaplicar);
		txtaplicar.setColumns(10);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(20, 153, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener()
				{
			
			public void actionPerformed(ActionEvent ae) {
				
				String numero_conta = txtnumero.getText();
				if(c.verificaCaracter(numero_conta))
				{
					
					if(c.isInteger(txtaplicar.getText()))
					{
						
						int n = Integer.parseInt(txtnumero.getText());
						float valor_aplicado =Float.parseFloat(txtaplicar.getText());
						if(valor_aplicado>0) {
						int i=c.retornaFlag(n);
							
								if(c.aplicarDinheiro(n, valor_aplicado, i)) {
								JOptionPane.showMessageDialog(null,"Dinheiro aplicado!");
								
								A.setExtrato("Aplicou");
								A.setNmr(n);
								A.setValor(valor_aplicado);
								c.adicionarExtrato(A);
								
								
								TelaCliente back = new TelaCliente();
								frame.setVisible(false);
								back.main(null);
								}
								else {
									txtnumero.setText("");
									txtaplicar.setText("");
									JOptionPane.showMessageDialog(null,"Número da conta nao existe!");
								}
						}
						else {
							txtnumero.setText("");
							txtaplicar.setText("");
							JOptionPane.showMessageDialog(null,"Valor não pode ser negativo!");
						}
						
					}
					else {
						txtnumero.setText("");
						txtaplicar.setText("");
						JOptionPane.showMessageDialog(null,"Valor invalido!");
					}
				}
				
				
			}
			
			
				});
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente back = new TelaCliente();
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
