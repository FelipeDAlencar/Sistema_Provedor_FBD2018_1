package br.com.sistema_provedor_fbd_2018_1.entidade;

public class ServicoCliente {
	private Integer id, servico_id, switch_id, porta_id, endereco_id;
	private Integer cliente_id;
	private String login, senha;
	private Endereco endereco;
	private String descricao;
	
	public ServicoCliente(Integer id, Integer servico_id, Integer switch_id, Integer porta_id, Integer endereco_id, 
			Integer cliente_id, String login, String senha, String  descricao) {
		super();
		this.id = id;
		this.servico_id = servico_id;
		this.switch_id = switch_id;
		this.porta_id = porta_id;
		this.endereco_id = endereco_id;
		this.cliente_id = cliente_id;
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
		
	}
	
	public ServicoCliente(Integer servico_id, Integer switch_id, Integer porta_id, Integer endereco_id, 
			Integer cliente_id, String login, String senha, String  descricao) {
		super();
		this.servico_id = servico_id;
		this.switch_id = switch_id;
		this.porta_id = porta_id;
		this.endereco_id = endereco_id;
		this.cliente_id = cliente_id;
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
	}
	
	public ServicoCliente(Integer servico_id, Integer switch_id, Integer porta_id, Integer endereco_id, 
			Integer cliente_id, String login, String senha) {
		super();
		this.servico_id = servico_id;
		this.switch_id = switch_id;
		this.porta_id = porta_id;
		this.endereco_id = endereco_id;
		this.cliente_id = cliente_id;
		this.login = login;
		this.senha = senha;
	}
	
	public ServicoCliente(Integer servico_id, Integer switch_id, Integer porta_id,Endereco endereco , 
			Integer cliente_id, String login, String senha, String  descricao) {
		super();
		this.servico_id = servico_id;
		this.switch_id = switch_id;
		this.porta_id = porta_id;
		this.endereco = endereco;
		this.cliente_id = cliente_id;
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
	}
	
	public ServicoCliente(Integer servico_id, Integer switch_id, Integer porta_id,Endereco endereco , 
			Integer cliente_id, String login, String senha) {
		super();
		this.servico_id = servico_id;
		this.switch_id = switch_id;
		this.porta_id = porta_id;
		this.endereco = endereco;
		this.cliente_id = cliente_id;
		this.login = login;
		this.senha = senha;
	}

	
	public ServicoCliente() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServico_id() {
		return servico_id;
	}

	public void setServico_id(Integer servico_id) {
		this.servico_id = servico_id;
	}

	public Integer getSwitch_id() {
		return switch_id;
	}

	public void setSwitch_id(Integer switch_id) {
		this.switch_id = switch_id;
	}

	public Integer getPorta_id() {
		return porta_id;
	}

	public void setPorta_id(Integer porta_id) {
		this.porta_id = porta_id;
	}

	public Integer getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
