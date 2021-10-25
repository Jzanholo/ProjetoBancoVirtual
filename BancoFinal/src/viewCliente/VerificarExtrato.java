package viewCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classes.Acoes;
import Classes.CadastraCliente;
import Classes.Controlador;
import Classes.Especial;
import Classes.Poupanca;
import Classes.Simples;
import view.TelaCliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerificarExtrato {

	private JFrame frame;
	private JTextField textnumero;
	private JTable table;
	DefaultTableModel model= new DefaultTableModel();
	
	private ArrayList<Acoes> dados_extrato =  Controlador.retornarDadosExtrato();
	CadastraCliente cc = new CadastraCliente();
	Controlador c = new Controlador();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificarExtrato window = new VerificarExtrato();
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
	public VerificarExtrato() {
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
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(c.verificaCaracter(textnumero.getText())) {
								
						for(Acoes ex : dados_extrato)
						{
							if(ex.getNmr()==(Integer.parseInt(textnumero.getText())))
							{
							Object[] fila= {
			
									ex.getExtrato(),
									ex.getValor(),
									
							};
							
								model.addRow(fila);
							
						}
						
						}			
					
				}
		}});
		
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero da conta: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 59, 132, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		textnumero = new JTextField();
		textnumero.setColumns(10);
		textnumero.setBounds(148, 61, 99, 20);
		frame.getContentPane().add(textnumero);
		
		JLabel lblNewLabel_1 = new JLabel("Verificar extrato");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(20, 10, 227, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 85, 394, 131);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Aplicou/Retirou");
		model.addColumn("Valor");
		
		table.setModel(model);
		
		JLabel fundotela = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/fundo12.png"));
		fundotela.setIcon(img);
		fundotela.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(fundotela);
	}

}
