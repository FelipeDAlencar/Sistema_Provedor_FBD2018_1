package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Funcionario {

	private Integer id, endereco_id;
	private String nome, cargo, data_contrato, login, senha;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer id, String nome, String cargo, String data_contrato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;

		this.data_contrato = data_contrato;
	};

	public Funcionario(Integer id, String nome, String cargo, String data_contrato, String login, String senha,
			Integer endereco_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.endereco_id = endereco_id;
		this.data_contrato = data_contrato;
		this.login = login;
		this.senha = senha;
	}

	public Funcionario(Integer id, String nome, String cargo, String data_contrato, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.data_contrato = data_contrato;
		this.login = login;
		this.senha = senha;
	}

	public Funcionario(Integer id, Integer endereco_id, String nome, String cargo, String data_contrato, String login,
			String senha) {
		super();
		this.id = id;
		this.endereco_id = endereco_id;
		this.nome = nome;
		this.cargo = cargo;
		this.data_contrato = data_contrato;
		this.login = login;
		this.senha = senha;
	}

	public Funcionario(String nome, String cargo, String data_contrato, String login, String senha) {
		this.nome = nome;
		this.cargo = cargo;

		this.data_contrato = data_contrato;
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

	public Integer getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
