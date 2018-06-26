package br.com.sistema_provedor_fbd_2018_1.sql;

public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/postgres";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "81540106";

	public static class Cliente {
		//Editar
		public static String INSERT_ALL = "insert into cliente (nome, codigo, carga_horaria) " + "values (?,?,?) ";
		
		public static final String SELECT_ID = "select * from cliente where id = ?";
		
	}

	public static class Funcionario {

		public static final String INSERT_ALL = "insert into funcionario (nome, codigo, carga_horaria) "
				+ "values (?,?,?) ";

		public static final String SELECT_ID = "select * from funcionario where id = ?";

	}
	public static class Cidade {
		public static String INSERT_ALL = "insert into cidade (nome, estado, cep) " + "values (?,?,?); ";
		
		public static final String SELECT_ID = "select * from cidade where id = ?";
		
		public static final String SELECT_ALL = "select * from cidade";
		
		
		public static final String UPDATE = "update cidade set  nome = ?, estado = ?, cep = ? where id = ?";
		
	}

}
