package Classes;

import java.util.ArrayList;

public class CadastraCliente {
	protected String login;
	protected String senha;
	protected String nome_gerente;
	protected String tipo_conta;
	public CadastraCliente(String login, String senha, String nome_gerente) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome_gerente = nome_gerente;
	}
	
	public CadastraCliente(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public String getTipo_conta() {
		return tipo_conta;
	}

	public void setTipo_conta(String tipo_conta) {
		this.tipo_conta = tipo_conta;
	}

	public CadastraCliente() {
		super();
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome_gerente() {
		return nome_gerente;
	}
	public void setNome_gerente(String nome_gerente) {
		this.nome_gerente = nome_gerente;
	}
	
	
	
}
