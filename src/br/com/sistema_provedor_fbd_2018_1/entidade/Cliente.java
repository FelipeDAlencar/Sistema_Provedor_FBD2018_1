package br.com.sistema_provedor_fbd_2018_1.entidade;


public class Cliente {

	private Integer id;
	private String nome, cpf, rg, data_nascimento;
	private Integer endereco_id;

	public Cliente(String nome, String cpf, String rg, String data_nascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nascimento = data_nascimento;
	}
	public Cliente(Integer id, String nome, String cpf, String rg, String data_nascimento, Integer endereco_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nascimento = data_nascimento;
		this.endereco_id = endereco_id;
	}
	public Cliente(Integer id, String nome, Integer endereco_id) {
		this.nome = nome;
		this.id = id;
		this.endereco_id = endereco_id;
		
	}
	public Cliente() {
		// TODO Auto-generated method stub

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Integer getEndereco_id() {
		return endereco_id;
	}
	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
	}
	

}
