package br.com.sistema_provedor_fbd_2018_1.entidade;

public class Contrato {

	private Integer id, cliente_id;
	private double valor_instalacao, valor_mensal;
	private String login, senha;
	private int numero_parcelas;

	public Contrato() {
		// TODO Auto-generated constructor stub
	}

	public Contrato(Integer id, Integer cliente_id, double valo_instalacao, double valor_mensal,
			String login, String senha, int numero_parcelas) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		
		this.valor_instalacao = valo_instalacao;
		this.valor_mensal = valor_mensal;
		this.login = login;
		this.senha = senha;
		this.numero_parcelas = numero_parcelas;
	}

	public Contrato(double valo_instalacao, double valor_mensal, String login, String senha, int numero_parcelas) {
		super();
		this.valor_instalacao = valo_instalacao;
		this.valor_mensal = valor_mensal;
		this.login = login;
		this.senha = senha;
		this.numero_parcelas = numero_parcelas;
	}

	
	
	public Contrato(Integer cliente_id, double valor_instalacao, double valor_mensal, String login,
			String senha, int numero_parcelas) {
		super();
		this.cliente_id = cliente_id;
		
		this.valor_instalacao = valor_instalacao;
		this.valor_mensal = valor_mensal;
		this.login = login;
		this.senha = senha;
		this.numero_parcelas = numero_parcelas;
	}

	public double getValor_instalacao() {
		return valor_instalacao;
	}

	public void setValor_instalacao(double valor_instalacao) {
		this.valor_instalacao = valor_instalacao;
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


	public double getValor_mensal() {
		return valor_mensal;
	}

	public void setValor_mensal(double valor_mensal) {
		this.valor_mensal = valor_mensal;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumero_parcelas() {
		return numero_parcelas;
	}

	public void setNumero_parcelas(int numero_parcelas) {
		this.numero_parcelas = numero_parcelas;
	}

}
