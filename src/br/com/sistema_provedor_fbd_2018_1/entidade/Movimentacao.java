package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Movimentacao {
	private Integer id;
	private String descricao, situacao, tipo, data_movimentacao;
	private double valor;
	private boolean status;

	
	public Movimentacao(Integer id, String descricao, String situacao, String tipo, String data_movimentacao,
			double valor, boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.situacao = situacao;
		this.tipo = tipo;
		this.data_movimentacao = data_movimentacao;
		this.valor = valor;
		this.status = status;
	}
	
	
	public Movimentacao(String descricao, String situacao, String tipo, String data_movimentacao, double valor,
			boolean status) {
		super();
		this.descricao = descricao;
		this.situacao = situacao;
		this.tipo = tipo;
		this.data_movimentacao = data_movimentacao;
		this.valor = valor;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData_movimentacao() {
		return data_movimentacao;
	}
	public void setData_movimentacao(String data_movimentacao) {
		this.data_movimentacao = data_movimentacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
	

}
