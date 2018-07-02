package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Endereco {
	
	private Integer id;
	private String bairro, complemento, rua;
	private int numero;
	private Integer cidade_id;
	
	public Endereco(String bairro, String complemento, String rua, int numero) {
		super();
		this.bairro = bairro;
		this.complemento = complemento;
		this.rua = rua;
		this.numero = numero;
	}
	public Endereco() {
		
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
	public Integer getCidade_id() {
		return cidade_id;
	}
	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}
	
	
	
	

}
