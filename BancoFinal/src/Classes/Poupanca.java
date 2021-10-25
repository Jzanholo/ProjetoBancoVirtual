package Classes;

import java.util.ArrayList;

public class Poupanca extends CadastraCliente{
	protected int numero_conta;
	protected float saldo;
	protected float limite;
	protected float taxaJuros;
	public String extrato;
	
	
	private static ArrayList<Poupanca> dados_poupanca =  Controlador.retornarDadosPoupanca();
	
	
	
	
	

	public String getExtrato() {
		return extrato;
	}

	public void setExtrato(String extrato) {
		this.extrato = extrato;
	}
	
	public float getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public Poupanca() {
		super();

	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public int getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
