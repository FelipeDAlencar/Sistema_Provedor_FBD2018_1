package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Servico {
	private Integer id;
	private String nome;
	private int upload, download;
	
	public Servico() {
		
	}

	public Servico(Integer id, String nome, int upload, int download) {
		super();
		this.id = id;
		this.nome = nome;
		this.upload = upload;
		this.download = download;
	}

	public Servico(String nome, int upload, int download) {
		super();
		this.nome = nome;
		this.upload = upload;
		this.download = download;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUpload() {
		return upload;
	}

	public void setUpload(int upload) {
		this.upload = upload;
	}

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}
	
	
	
	

}
