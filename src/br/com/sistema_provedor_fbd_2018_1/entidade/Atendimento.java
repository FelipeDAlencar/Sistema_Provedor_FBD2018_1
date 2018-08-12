package br.com.sistema_provedor_fbd_2018_1.entidade;

import br.com.sistema_provedor_fbd_2018_1.enuns.enumAtendimento;

public class Atendimento {
	
	private Integer id, cliente_id;
	private String descricao;
	private String motivo, data_atendimento;
	private enumAtendimento status;



	public Atendimento( String motivo, String data_atendimento,
			String descricao) {
		super();
		this.motivo = motivo;
		this.data_atendimento = data_atendimento;
	}


	public Atendimento(Integer id, Integer cliente_id, String motivo,
			String data_atendimento, enumAtendimento status, String descricao) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.motivo = motivo;
		this.data_atendimento = data_atendimento;
		this.status = status;
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

	public String getDescricao() {
		return descricao;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public enumAtendimento getStatus() {
		return status;
	}
	
	public void setStatus(enumAtendimento status) {
		this.status = status;
	}

	public String getData_atendimento() {
		return data_atendimento;
	}


	public void setData_atendimento(String data_atendimento) {
		this.data_atendimento = data_atendimento;
	}
	
	
	
	
	
	
	
	
	
	

}
