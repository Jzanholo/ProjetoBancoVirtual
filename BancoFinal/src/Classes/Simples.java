package Classes;

import java.util.ArrayList;

public class Simples extends CadastraCliente{
	protected int numero_conta;
	protected float saldo;
	protected float limite;
	public String extrato;
	
	private static ArrayList<Simples> dados_extrato =  new ArrayList<>();
	private static ArrayList<Simples> dados_simples =  Controlador.retornarDadosSimples();
	
	public void adicionarExtrato(Simples s)
	{
		dados_extrato.add(s);
	}
	public static ArrayList<Simples > retornarDadosExtrato() {
		return dados_extrato;
	}

	public String getExtrato() {
		return extrato;
	}

	public void setExtrato(String extrato) {
		this.extrato = extrato;
	}
	


	public Simples() {
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

