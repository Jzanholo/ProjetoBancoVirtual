package Classes;

public class CadastraGerente {
	protected String login;
	protected String senha;
	
	public CadastraGerente(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public CadastraGerente() {
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
	
}
