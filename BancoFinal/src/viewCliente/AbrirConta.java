package viewCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Classes.Controlador;
import Classes.Especial;
import Classes.Poupanca;
import Classes.Simples;
import view.TelaCliente;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AbrirConta{
	Controlador c = new Controlador();
	Poupanca p = new Poupanca();
	Simples s = new Simples();
	Especial es = new Especial();
	private JFrame frame;
	private JTextField txtnumero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirConta window = new AbrirConta();
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
	public AbrirConta() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Abrir conta");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(20, 10, 174, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox txtcombo = new JComboBox();
		txtcombo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcombo.setModel(new DefaultComboBoxModel(new String[] {"Poupan\u00E7a", "Especial", "Simples"}));
		txtcombo.setMaximumRowCount(3);
		txtcombo.setBounds(20, 59, 83, 22);
		frame.getContentPane().add(txtcombo);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero da conta: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 92, 133, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtnumero = new JTextField();
		txtnumero.setBounds(149, 94, 99, 20);
		frame.getContentPane().add(txtnumero);
		txtnumero.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String escolha = (String)txtcombo.getSelectedItem();
				String numero_conta = txtnumero.getText();
				if(c.verificaCaracter(numero_conta))
				{
					int n = Integer.parseInt(numero_conta);
				switch(escolha) {
					
				case "Poupança": 	
									if(c.existeNumeroContas(n))
									{
										txtnumero.setText("");
										JOptionPane.showMessageDialog(null,"Número da conta já cadastrado, digite outro!");
									}
									else 
									{
										p.setNumero_conta(n);
										p.setLogin(c.getUsando());
										p.setNome_gerente(c.gerente_usado());
										c.adicionarNumeroContaPoupanca(p);

										JOptionPane.showMessageDialog(null,"Conta poupança foi criada!");
										TelaCliente back = new TelaCliente();
										frame.setVisible(false);
										back.main(null);

									}
									break;
				case "Simples": 
									if(c.existeNumeroContas(n))
									{
										txtnumero.setText("");
										JOptionPane.showMessageDialog(null,"Número da conta já cadastrado, digite outro!");
									}
									else 
									{
									
										s.setNumero_conta(n);
										s.setLogin(c.getUsando());
										s.setNome_gerente(c.gerente_usado());
										c.adicionarNumeroContaSimples(s);
										
										JOptionPane.showMessageDialog(null,"Conta simples foi criada!");
										TelaCliente back = new TelaCliente();
										frame.setVisible(false);
										back.main(null);
									}
					
									break;
					
						case "Especial": 	if(c.existeNumeroContas(n))
											{
												txtnumero.setText("");
												JOptionPane.showMessageDialog(null,"Número da conta já cadastrado, digite outro!");
											}
											else 
											{
												
												es.setNumero_conta(n);
												es.setLogin(c.getUsando());
												es.setNome_gerente(c.gerente_usado());
												c.adicionarNumeroContaEspecial(es);
												
												JOptionPane.showMessageDialog(null,"Conta especial foi criada!");
												TelaCliente back = new TelaCliente();
												frame.setVisible(false);
												back.main(null);
											}
					
									break;
				}
				}
				else {
					JOptionPane.showMessageDialog(null,"O número da conta deve conter apenas números");
					txtnumero.setText("");
				}
			}
		});
		
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(20, 135, 109, 23);
		frame.getContentPane().add(btnNewButton);
		JLabel fundotela = new JLabel("");
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}
}
