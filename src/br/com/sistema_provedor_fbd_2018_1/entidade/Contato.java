package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Contato {

	private Integer id, cliente_id;
	private String responsavel, tipo, contato;

	public Contato() {
	}

	public Contato(int id, String responsavel, String tipo, String contato) {
		super();
		this.id = id;
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.contato = contato;
	}
	
	public Contato(String responsavel, String tipo, String contato) {
		super();
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.contato = contato;
	}

	public Contato(Integer id, Integer cliente_id, String tipo, String contato) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.tipo = tipo;
		this.contato = contato;
	}
	
	public Contato(Integer id, Integer cliente_id, String responsavel, String tipo, String contato) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.contato = contato;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

	public String getContato() {
		return contato;
	}

	public String getResponsavel() {
		return responsavel;
	}

}
