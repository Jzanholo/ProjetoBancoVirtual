package viewGerente;

import Classes.Controlador;
import Classes.Especial;
import Classes.Poupanca;
import Classes.Simples;

import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import Classes.CadastraCliente;
import Classes.Controlador;
import view.TelaGerente;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class VerificarNomeCliente {
	Controlador c = new Controlador();
	private ArrayList<Poupanca> dados_poupanca =  Controlador.retornarDadosPoupanca();
	private ArrayList<Simples> dados_simples =  Controlador.retornarDadosSimples();
	private ArrayList<Especial> dados_especial =  Controlador.retornarDadosEspecial();
	private JFrame frame;
	private JTable table;
	DefaultTableModel model= new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificarNomeCliente window = new VerificarNomeCliente();
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
	public VerificarNomeCliente() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Verificar informa\u00E7\u00F5es da conta");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 10, 414, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
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
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Poupanca i : dados_poupanca)
				{
					if(c.getUsando().equals(i.getNome_gerente())) {
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta()
						};
							model.addRow(fila);
					}
				}
				for(Simples i : dados_simples)
				{
					if(c.getUsando().equals(i.getNome_gerente())) {
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta()
						};
							model.addRow(fila);
					}
				}
				for(Especial i : dados_especial)
				{
					if(c.getUsando().equals(i.getNome_gerente())) {
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta()
						};
							model.addRow(fila);
					}
				}
			}
			
		});
		btnVerificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificar.setBounds(325, 227, 89, 23);
		frame.getContentPane().add(btnVerificar);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 73, 394, 131);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nome");
		model.addColumn("Numero da conta");
		table.setModel(model);
		
		
		
		
		JLabel fundotela = new JLabel("");
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
		
	}
}
