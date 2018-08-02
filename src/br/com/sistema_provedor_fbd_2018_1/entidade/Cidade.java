package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Cidade {
	private Integer id;
	private String nome, estado, cep;
	private boolean status;

	public Cidade() {

	}

	public Cidade(Integer id, String nome, String estado, String cep, boolean  status ) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.cep = cep;
		this.status = status;
	}

	public Cidade(String nome, String estado, String cep, boolean status) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.cep = cep;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
