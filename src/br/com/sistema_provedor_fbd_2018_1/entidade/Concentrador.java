package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Concentrador {

	private Integer id, cidade_id;
	private String nome, ip, login, senha;

	public Concentrador() {
		// TODO Auto-generated constructor stub
	}

	public Concentrador(Integer id, Integer cidade_id, String nome, String ip, String login, String senha) {
		super();
		this.id = id;
		this.cidade_id = cidade_id;
		this.nome = nome;
		this.ip = ip;
		this.login = login;
		this.senha = senha;
	}

	public Concentrador(String nome, String ip, String login, String senha) {
		super();
		this.nome = nome;
		this.ip = ip;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
