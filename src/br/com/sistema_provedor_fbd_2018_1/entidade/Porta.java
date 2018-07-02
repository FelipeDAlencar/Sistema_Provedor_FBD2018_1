package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Porta {

	private Integer id, switch_id;
	private int numero;

	
	public Porta() {
		// TODO Auto-generated constructor stub
	}
	
	public Porta(Integer id, Integer switch_id, int numero) {
		super();
		this.id = id;
		this.switch_id = switch_id;
		this.numero = numero;
	}

	public Porta(int numero) {
		super();
		this.switch_id = switch_id;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSwitch_id() {
		return switch_id;
	}

	public void setSwitch_id(Integer switch_id) {
		this.switch_id = switch_id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
