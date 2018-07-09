package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Atendimento {
	
	private Integer id, cliente_id;
	private String motivo, protocolo, status;
	
	
	public Atendimento() {
		// TODO Auto-generated constructor stub
	}


	public Atendimento( String motivo, String protocolo) {
		super();
		this.motivo = motivo;
		this.protocolo = protocolo;
	}


	public Atendimento(Integer id, Integer cliente_id, String motivo, String protocolo) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.motivo = motivo;
		this.protocolo = protocolo;
		this.status = "Fechado";
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


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public String getProtocolo() {
		return protocolo;
	}


	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	

}
