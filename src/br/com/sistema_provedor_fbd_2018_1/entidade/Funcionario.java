package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Funcionario {

	private Integer id;
	private String nome, cargo, data_nascimento, data_contrato, login, senha;

	public Funcionario(Integer id, String nome, String cargo, String data_nascimento, String data_contrato,
			String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.data_nascimento = data_nascimento;
		this.data_contrato = data_contrato;
		this.login = login;
		this.senha = senha;
	}
	
	
	public Funcionario(Integer id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getData_contrato() {
		return data_contrato;
	}

	public void setData_contrato(String data_contrato) {
		this.data_contrato = data_contrato;
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
