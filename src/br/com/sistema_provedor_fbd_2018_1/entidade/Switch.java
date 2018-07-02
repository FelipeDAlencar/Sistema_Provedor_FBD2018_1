package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Switch {
	
	private Integer id, caixa_id, concentrador_id;
	private String nome, ip, login, senha;
	private int numero_de_portas;
	
	
	
	
	public Switch() {
		// TODO Auto-generated constructor stub
	}
	
	public Switch(Integer id, Integer caixa_id, Integer concentrador_id, String nome, String ip, String login,
			String senha, int numero_de_portas) {
		super();
		this.id = id;
		this.caixa_id = caixa_id;
		this.concentrador_id = concentrador_id;
		this.nome = nome;
		this.ip = ip;
		this.login = login;
		this.senha = senha;
		this.numero_de_portas = numero_de_portas;
	}
	public Switch( String nome, String ip, String login, String senha,
			int numero_de_portas) {
		super();
		this.nome = nome;
		this.ip = ip;
		this.login = login;
		this.senha = senha;
		this.numero_de_portas = numero_de_portas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCaixa_id() {
		return caixa_id;
	}

	public void setCaixa_id(Integer caixa_id) {
		this.caixa_id = caixa_id;
	}

	public Integer getConcentrador_id() {
		return concentrador_id;
	}

	public void setConcentrador_id(Integer concentrador_id) {
		this.concentrador_id = concentrador_id;
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

	public int getNumero_de_portas() {
		return numero_de_portas;
	}

	public void setNumero_de_portas(int numero_de_portas) {
		this.numero_de_portas = numero_de_portas;
	}
	
	
	

}
