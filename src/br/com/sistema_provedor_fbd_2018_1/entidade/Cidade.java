package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Cidade {
	private Integer id;
	private String nome, estado, cep;

	public Cidade() {

	}

	public Cidade(Integer id, String nome, String estado, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.cep = cep;
	}

	public Cidade(String nome, String estado, String cep) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
