package Classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.Usuario;

public class Menu {
	
	public static void main(String[] args) {
		
		Controlador c = new Controlador();
		CadastraGerente cg = new CadastraGerente();
		
		cg.setLogin("admin");
		cg.setSenha("123");
		c.adicionarGerente(cg);
		
		Usuario.main(args);

	}
	
}
