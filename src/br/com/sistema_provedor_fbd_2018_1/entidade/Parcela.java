package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Parcela {

	private Integer id, contrato_id;
	private Double valor;
	private String data_vencimento;
	private boolean status;

	public Parcela(Integer id, Integer contrato_id, Double valor, String data_vencimento, boolean status) {
		super();
		this.id = id;
		this.contrato_id = contrato_id;
		this.valor = valor;
		this.data_vencimento = data_vencimento;
		this.status = status;
	}

	public Parcela(Integer id, Double valor, String data_vencimento, boolean status) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_vencimento = data_vencimento;
		this.status = status;
	}

	public Parcela(Double valor, String data_vencimento, boolean status) {
		super();
		this.valor = valor;
		this.data_vencimento = data_vencimento;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContrato_id() {
		return contrato_id;
	}

	public void setContrato_id(Integer contrato_id) {
		this.contrato_id = contrato_id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
