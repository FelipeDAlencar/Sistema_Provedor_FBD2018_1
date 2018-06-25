package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Endereco {
	
	private Integer id;
	private String bairro, complemento, rua;
	private int numero;
	public Endereco(Integer id, String bairro, String complemento, String rua, int numero) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.complemento = complemento;
		this.rua = rua;
		this.numero = numero;
	}
	public Endereco(Integer id, String bairro, String rua) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.rua = rua;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	

}
