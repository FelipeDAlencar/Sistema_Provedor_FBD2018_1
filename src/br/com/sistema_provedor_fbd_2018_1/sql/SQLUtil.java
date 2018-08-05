package br.com.sistema_provedor_fbd_2018_1.sql;

public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/postgres";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "81540106";
	
	public static class Cliente {
		// Editar
		public static String INSERT_ALL = "insert into cliente (nome, cpf, rg, data_nascimento, endereco_id) "
				+ "values (?,?,?,?,?) ";

		public static final String SELECT_ID = "select * from cliente where id = ?";

		public static final String SELECT_CPF = "select * from cliente where cpf = ?";

		public static final String SELECT_ALL = "select * from cliente";
		
		public static final String MAXID = "select MAX(id) from cliente";
		
		public static final String UPDATE = "update cliente set nome = ?, cpf = ?, rg = ?, data_nascimento = ? endereco = id ? where id = ? ";
		
		public static String SELECT_PORBUSCA = "select * from cliente where nome ilike ?";

	}

	public static class Funcionario {

		public static final String INSERT_ALL = "insert into funcionario (nome, cargo, data_contrato, login, senha, endereco_id)"
				+ "values (?,?,?,?,?,?) ";

		public static final String SELECT_ID = "select * from funcionario where id = ?";

		public static final String UPDATE = "update funcionario set nome = ?, cargo = ?, data_contrato = ?, login = ?, senha = ?, endereco_id = ? where id = ? ";
		
		public static String SELECT_ALL = "select * from funcionario";
		
		public static String SELECT_PORBUSCA = "select * from funcionario where nome ilike 	? or cargo ilike ? "
				+ "or login ilike ? or to_char(data_contrato, 'yyyy/MM/dd hh:mm:ss')   like ?";
	}

	public static class Cidade {
		public static String INSERT_ALL = "insert into cidade (nome, estado, status, cep) " + "values (?,?,?,?); ";

		public static final String SELECT_ID = "select * from cidade where id = ? and status = true";

		public static final String SELECT_NOME = "select * from cidade where nome = ?and status = true";

		public static final String SELECT_CEP = "select * from cidade where cep = ? and status = true";

		public static final String MAXID = "select MAX(id) from cidade and status = true";

		public static final String SELECT_ALL = "select * from cidade";

		public static final String UPDATE = "update cidade set  nome = ?, estado = ?, cep = ? where id = ?";
		
		public static final String SELECT_NOMEESTADO = "select * from cidade where nome = ? and estado = ? and status = true ";
		
		public static final String SELECT_PORBUSCA = "select * from cidade where nome  ilike ? or estado ilike ? or "
				+ "cep ilike ? and status = true";

	}

	public static class Endereco {
		public static String INSERT_ALL = "insert into endereco (numero, rua, bairro, cidade_id) "
				+ "values (?,?,?,?)";

		public static String MAXID = "select MAX(id) from endereco";

		public static final String SELECT_ID = "select * from endereco where id = ?";

		public static final String SELECT_ALL = "select * from endereco";

		public static final String UPDATE = "update endereco set  nome = ?, numero = ?, rua = ?, bairro = ?, cidade_id = ? where id = ?";

	}

	public static class Servico {
		

		public static String SELECT_ALL = "select * from servico";
		
		public static String INSERT_ALL = "insert into servico (nome, download, upload) values (?,?,?); ";
		
		public static String SELECT_ID = "select * from servico where id = ?";
		
		public static String UPDATE = "update servico set nome = ?, download = ?, upload = ? where id = ?";
		
		public static String SELECT_PORBUSCA = "select * from servico where nome ilike ?";
		
		public static String SELECT_NOME = "select * from servico where nome = ?";
	}

	public static class Contato {
		public static String SELECT_CLIENTE = "SELECT * FROM CONTATO WHERE cliente_id = ?" ;
		
		public static String INSERT_ALL = "insert into contato (responsavel,tipo,contato, cliente_id) "
				+ "values (?,?,?,?); ";
		public static String SELECT_ID = "select * from contato where id = ?";
		
		public static String SELECT_ALL = "select * from contato";
	}

	public static class Atendimento {
		public static String INSERT_ALL = "insert into atendimento (motivo, protocolo, data_atendimento, cliente_id) "
		+ "values (?,?,?,?); ";
		
		public static String SELECT_ALL = "select * from atendimento"; 
		
		public static String SELECT_ATRASADOS ="select * from atendimento where data_atendimento  <  ?";
		
		public static String UPDATE = "update atendimento set motivo = ?, protocolo = ?, data_atendimento = ?, cliente_id = ?"
				+ "where id = ?";
	}	

	public static class Caixa {
		public static String INSERT_ALL = "insert into caixa (nome, latitude, longitude, cidade_id ) "
				+ "values (?,?,?,?); ";

		public static String SELECT_NOME = "select * from caixa where nome = ?";
		
		public static String SELECT_ALL = "select * from caixa";
		
		public static String SELECT_ID = "select * from caixa where id = ?";
		
		public static String UPDATE =  "update caixa set nome = ?, latitude = ?, longitude = ?, cidade_id = ? "
				+ "where id = ? ";
		
		public static String SELECT_PORBUSCA = "select * from caixa where nome ilike ? "
				+ "or latitude ilike ? or longitude ilike ?";
	}

	public static class Concentrador {
		public static final String SELECT_PORBUSCA = "select * from concentrador where nome ilike ? or "
				+ "ip ilike ?";
		
		public static String INSERT_ALL = "insert into concentrador (nome, ip, login, senha, cidade_id) "
				+ "values (?,?,?,?,?); ";
		public static String SELECT_NOME = "select * from concentrador where nome = ?";

		public static String SELECT_ALL = "select * from concentrador";
		
		public static String SELECT_ID = "select * from concentrador where id = ?";
		
		public static String UPDATE = "update concentrador set nome = ?, ip = ?, login = ?, senha = ? where id = ?";
	}

	public static class Switch {
	
		
		public static String INSERT_ALL = "insert into switch (nome, numero_de_portas, ip, login, senha, caixa_id, concentrador_id) "
				+ "values (?,?,?,?,?,?,?); ";
		public static String SELECT_NOME = "select * from switch where nome = ?";
		
		public static String SELECT_ALL = "select * from switch";
		
		public static String SELECT_ID = "select * from switch where id = ?";
		
		public static String UPDATE = "update switch set nome = ?, numero_de_portas = ?, ip = ?, login = ?, senha = ?, caixa_id = ?, concentrador_id = ? where id = ?";
	
		public static String SELECT_PORBUSCA = "select * from switch where nome ilike ? or "
				+ "ip ilike ? or login ilike ?";
		
		public static String SELECT_MAXID = "select MAX(ID) from  switch ";
	
	}

	public static class Porta {
		public static final String SELECT_SWITCH_NOME = "select * from porta where switch_id = ?  and numero = ?";
		
		public static String INSERT_ALL = "insert into porta (numero, switch_id) " + "values (?,?); ";

		public static String SELECT_NUMERO = "select * from porta where numero = ?";
		
		public static String SELECT_SWITCH = "select * from porta where switch_id = ?";
	}

	public static class Contrato {
		public static String INSERT_ALL = "insert into contrato (valor_instalacao, valor_mensal, login, senha, numero_parcelas, cliente_id) "
				+ "values (?,?,?,?,?,?); ";
		public static String SELECT_MAXID = "select MAX(ID) from  contrato ";
		
		public static String SELECT_PORCLIENTE_ID = "select * from contrato where cliente_id = ?";
	}
	
	
	public static class Movimentacao{
		public static final String INSERT_ALL = "insert into movimentacao (descricao, situacao, valor, data_movimentacao, status, tipo) values (?,?,?,?,?,?)  ";
		
		public static final String SELECT_ALL = "select * from movimentacao where status = true";
		
		public static final String SELECT_ID = "select * from movimentacao where id = ? and status = true";
		
		public static final String SELECT_PORBUSCA = "select * from movimentacao where situacao = ? and descricao ilike ?  ";
		
		public static  final String SELECT_PAGO = "select * from movimentacao where situacao = 'Pago'";
		
		public static  final String SELECT_NAOPAGO = "select * from movimentacao where situacao = 'Aguardando pagamento'";
		
		public static final String  UPDATE = "update movimentacao set descricao = ?, situacao = ?, valor = ?, data_movimentacao = ?, tipo = ? where id = ?";
		
	}
	
	public static class Parcela{
		
		public static String INSERT_ALL = "insert into parcela(valor, data_vencimento, status, contrato_id) "
				+ "values (?,?,?,?)";
		
		public static String SELECT_ALL = "select * from parcela";
		
		public static String UPDATE = "update parcela set valor = ?, data_vencimento = ?, status = ? where id = ?";
		
		public static String SELECT_ID = "select * from parcela where id = ?";
		
		public static String SELECT_PORCOTRATOID = "select * from parcela where contrato_id = ?"; 
	}
	
	public static class ServicoCliente{
		
		public static String INSERT_ALL = "insert into ServicoCliente(servico_id, switch_id, porta_id, endereco_id, cliente_id) "
				+ "values (?,?,?,?,?)";
		public static String SELECT_ALL = "select * from ServicoCliente";
		
		public static String SELECT_ID = "select * from ServicoCliente where id = ?";
		
		public static String SELECT_CLIENTE = "select * from ServicoCliente where cliente_id = ?";
		
		
		
		
		
		
	}
	
}
