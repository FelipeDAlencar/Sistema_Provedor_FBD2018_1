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

	}

	public static class Funcionario {

		public static final String INSERT_ALL = "insert into funcionario (nome, cargo, data_contrato, login, senha, endereco_id)"
				+ "values (?,?,?,?,?,?) ";

		public static final String SELECT_ID = "select * from funcionario where id = ?";

		public static final String UPDATE = "update funcionario set nome = ?, cargo = ?, data_contrato = ?, login = ?, senha = ?, endereco_id = ? where id = ? ";
		
		public static String SELECT_ALL = "select * from funcionario";
	}

	public static class Cidade {
		public static String INSERT_ALL = "insert into cidade (nome, estado, cep) " + "values (?,?,?); ";

		public static final String SELECT_ID = "select * from cidade where id = ?";

		public static final String SELECT_NOME = "select * from cidade where nome = ?";

		public static final String SELECT_CEP = "select * from cidade where cep = ?";

		public static final String MAXID = "select MAX(id) from cidade";

		public static final String SELECT_ALL = "select * from cidade";

		public static final String UPDATE = "update cidade set  nome = ?, estado = ?, cep = ? where id = ?";

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
	}

	public static class Contato {
		public static String INSERT_ALL = "insert into contato (responsavel,tipo,contato, cliente_id) "
				+ "values (?,?,?,?); ";
	}

	public static class Atendimento {
		public static String INSERT_ALL = "insert into atendimento (motivo, protocolo, cliente_id) "
				+ "values (?,?,?); ";
	}

	public static class Caixa {
		public static String INSERT_ALL = "insert into caixa (nome, latitude, longitude, cidade_id ) "
				+ "values (?,?,?,?); ";

		public static String SELECT_NOME = "select * from caixa where nome = ?";
		
		public static String SELECT_ALL = "select * from caixa";
		
		public static String SELECT_ID = "select * from caixa where id = ?";
		
		public static String UPDATE =  "update caixa set nome = ?, latitude = ?, longitude = ?, cidade_id = ? "
				+ "where id = ? ";
	}

	public static class Concentrador {
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
	}

	public static class Porta {
		public static String INSERT_ALL = "insert into porta (numero, switch_id) " + "values (?,?); ";

		public static String SELECT_NUMERO = "select * from porta where numero = ?";
	}

	public static class Contrato {
		public static String INSERT_ALL = "insert into contrato (valor_instalacao, valor_mensal, login, senha, numero_parcelas, cliente_id, porta_id) "
				+ "values (?,?,?,?,?,?,?); ";
	}

}
