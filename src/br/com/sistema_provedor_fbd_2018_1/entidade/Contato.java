package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Contato {
	
	private Integer id, cliente_id;
	private String tipo, email, telefone, celular;
	
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Contato( String tipo, String email, String telefone, String celular) {
		super();
		this.tipo = tipo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}
	public Contato(Integer id, Integer cliente_id, String tipo, String email, String telefone, String celular) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.tipo = tipo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
}
