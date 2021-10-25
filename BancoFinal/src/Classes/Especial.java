package Classes;

import java.util.ArrayList;

public class Especial extends CadastraCliente{
	protected int numero_conta;
	protected float saldo;
	protected float limite;
	public String extrato;
	
	

	public Especial() {
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

