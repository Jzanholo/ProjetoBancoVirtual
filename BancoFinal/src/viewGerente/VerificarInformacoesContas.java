package viewGerente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classes.Acoes;
import Classes.Controlador;
import Classes.Especial;
import Classes.Poupanca;
import Classes.Simples;
import view.TelaGerente;

import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerificarInformacoesContas {
	Controlador c = new Controlador();
	private ArrayList<Poupanca> dados_poupanca =  Controlador.retornarDadosPoupanca();
	private ArrayList<Simples> dados_simples =  Controlador.retornarDadosSimples();
	private ArrayList<Especial> dados_especial =  Controlador.retornarDadosEspecial();
	private ArrayList<Acoes> dados_extrato =  Controlador.retornarDadosExtrato();
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
					VerificarInformacoesContas window = new VerificarInformacoesContas();
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
	public VerificarInformacoesContas() {
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
		btnVerificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificar.setBounds(325, 227, 89, 23);
		frame.getContentPane().add(btnVerificar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 58, 394, 158);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nome");
		model.addColumn("Nº conta");
		model.addColumn("Tipo");
		model.addColumn("Extrato");
		model.addColumn("Valor extrato");
		table.setModel(model);
		
		for(Poupanca i : dados_poupanca)
		{
			if(c.getUsando().equals(i.getNome_gerente())) {
				for(Acoes ex : dados_extrato) {
					if(ex.getNmr()==i.getNumero_conta()){
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta(),
								"Poupanca",
								ex.getExtrato(),
								ex.getValor(),
						};
							model.addRow(fila);
					}
				}
			}
		}
		for(Simples i : dados_simples)
		{
			if(c.getUsando().equals(i.getNome_gerente())) {
				for(Acoes ex : dados_extrato) {
					if(ex.getNmr()==i.getNumero_conta()){
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta(),
								"Simples",
								ex.getExtrato(),
								ex.getValor(),
						};
							model.addRow(fila);
					}
				}
			}
		}
		for(Especial i : dados_especial)
		{
			if(c.getUsando().equals(i.getNome_gerente())) {
				for(Acoes ex : dados_extrato) {
					if(ex.getNmr()==i.getNumero_conta()){
						Object[] fila= {
								i.getLogin(),
								i.getNumero_conta(),
								"Especial",
								ex.getExtrato(),
								ex.getValor(),
						};
							model.addRow(fila);
					}
				}
			}
		}
		
		JLabel fundotela = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}
}
