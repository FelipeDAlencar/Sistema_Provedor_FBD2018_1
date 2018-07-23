package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Caixa {
	
	private Integer id, cidade_id;
	private String nome, latitude, longitude;
	
	public Caixa() {
		// TODO Auto-generated constructor stub
	}

	public Caixa(Integer id, String nome, String latitude, String longitude, Integer cidade_id) {
		super();
		this.id = id;
		this.cidade_id = cidade_id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Caixa(Integer id, String nome, String latitude, String longitude) {
		super();
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	public Caixa(String nome, String latitude, String longitude) {
		super();
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	

}
