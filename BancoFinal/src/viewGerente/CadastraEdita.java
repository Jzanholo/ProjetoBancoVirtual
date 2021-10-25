package viewGerente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import Classes.CadastraCliente;
import Classes.Controlador;
import Classes.Especial;
import Classes.Poupanca;
import view.TelaGerente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastraEdita {
	Controlador c = new Controlador();

	Poupanca p = new Poupanca();
	private JFrame frame;
	private JTextField textnumero;
	private JTextField textLimite;
	private JTextField textJuros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraEdita window = new CadastraEdita();
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
	public CadastraEdita() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Edita limites de retiradas e taxas ");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 10, 414, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero da conta: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 66, 133, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		textnumero = new JTextField();
		textnumero.setColumns(10);
		textnumero.setBounds(149, 68, 99, 20);
		frame.getContentPane().add(textnumero);
		
		JLabel lblNewLabel_3 = new JLabel("Defina o limite de retirada e taxa de juros");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 100, 300, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel txtLimite = new JLabel("Limite de retirada: ");
		txtLimite.setForeground(Color.WHITE);
		txtLimite.setFont(new Font("Arial", Font.BOLD, 14));
		txtLimite.setBounds(20, 125, 153, 22);
		frame.getContentPane().add(txtLimite);
		
		textLimite = new JTextField();
		textLimite.setColumns(10);
		textLimite.setBounds(149, 127, 99, 20);
		frame.getContentPane().add(textLimite);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Taxa de juros: ");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(20, 156, 133, 22);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		textJuros = new JTextField();
		textJuros.setColumns(10);
		textJuros.setBounds(149, 158, 99, 20);
		frame.getContentPane().add(textJuros);
		
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		
				
				String numero_conta = textnumero.getText();
				
				
				if(c.verificaCaracter(numero_conta))
				{
					
					
					if(c.isInteger(textLimite.getText()) && c.isInteger(textJuros.getText())) {
						
					
						float limite = Float.parseFloat(textLimite.getText());
						float TaxaJuros = Float.parseFloat(textJuros.getText());
						p.setTaxaJuros(TaxaJuros);
						
						
						int numero_account = Integer.parseInt( textnumero.getText());	
						if(c.cadastraEditaLimite(numero_account, limite))
						{
							
							JOptionPane.showMessageDialog(null," Conta: " + numero_account +"\n Limite: "+ limite+ "\n Taxa de juros: "+ TaxaJuros +"%");
						}else {JOptionPane.showMessageDialog(null,"Essa conta não pode ter limite");}
						
						
						
						
					
					
					
				}
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setBounds(306, 227, 103, 23);
		frame.getContentPane().add(btnEditar);
		
		JLabel fundo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		fundo.setIcon(img);
		fundo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundo);
	}
}
