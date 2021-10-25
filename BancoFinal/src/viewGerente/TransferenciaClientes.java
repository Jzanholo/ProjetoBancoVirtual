package viewGerente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import Classes.Controlador;
import view.TelaGerente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferenciaClientes {
	Controlador c = new Controlador();
	private JFrame frame;
	private JTextField txtenvia;
	private JTextField txtrecebe;
	private JTextField txtvalor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferenciaClientes window = new TransferenciaClientes();
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
	public TransferenciaClientes() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Transfer\u00EAncia entre clientes");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 10, 414, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite o n\u00FAmero da conta que ir\u00E1: ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 58, 237, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enviar:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(20, 94, 62, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtenvia = new JTextField();
		txtenvia.setBounds(92, 96, 99, 20);
		frame.getContentPane().add(txtenvia);
		txtenvia.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Receber:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(20, 125, 75, 22);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		txtrecebe = new JTextField();
		txtrecebe.setColumns(10);
		txtrecebe.setBounds(92, 127, 99, 20);
		frame.getContentPane().add(txtrecebe);
		
		JButton btnNewButton = new JButton("Transferir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.verificaCaracter(txtenvia.getText())&&c.verificaCaracter(txtrecebe.getText()))
				{
						if(c.isInteger(txtvalor.getText()))
						{
							int envia = Integer.parseInt(txtenvia.getText());
							int recebe = Integer.parseInt(txtrecebe.getText());
							float valor_transfere =Float.parseFloat(txtvalor.getText());
							
							if(c.existeNumeroContas(envia)&&(c.existeNumeroContas(recebe)))
							{
								if(c.transferencia(envia, recebe, valor_transfere))
									JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso!");
							}
							else {
								txtenvia.setText("");
								txtvalor.setText("");
								txtrecebe.setText("");
								JOptionPane.showMessageDialog(null,"Número da conta não existe!");
								
							}
						}
						else {
							txtenvia.setText("");
							txtvalor.setText("");
							txtrecebe.setText("");
							JOptionPane.showMessageDialog(null,"Valor inválido!");
						}
				}
				else {
					txtenvia.setText("");
					txtvalor.setText("");
					txtrecebe.setText("");
					JOptionPane.showMessageDialog(null,"Número inválido!");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(325, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Valor: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(20, 160, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtvalor = new JTextField();
		txtvalor.setBounds(92, 158, 99, 20);
		frame.getContentPane().add(txtvalor);
		txtvalor.setColumns(10);
		
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
