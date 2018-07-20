package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCliente implements IDaoCliente {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Cliente cliente) throws DaoException {
		try {

			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			this.statement = conexao.prepareStatement(SQLUtil.Endereco.MAXID);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();

			int endereco_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Cliente.INSERT_ALL);
		
			// statement.setString(Indice, valor);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getRg());
			statement.setDate(4, converterParaData(cliente.getData_nascimento()));
			statement.setInt(5, endereco_id);
			
			statement.execute();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO INSERIR UM CLIENTE - CONTACTE A EQUIPE RESPONSÁVEL");
		}

	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
	}
	
	public ArrayList<Atendimento> listarTodos()throws DaoException{
		
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_ALL);
			ArrayList<Atendimento> atendimetos = new ArrayList<>();

			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Atendimento atendimento =  new Atendimento(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getString(4));
				atendimetos.add(atendimento);

			}
			return atendimetos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CONSULTAR O BANCO DE DADOS.");

		}
	}

	@Override
	public Cliente buscarPorId(int id) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Cliente cliente = null;
			if (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			} else {
				throw new DaoException("CLIENTE NÃO CADASTRADO");
			}
			conexao.close();
			return cliente;
		} catch (Exception e) {
			throw new DaoException("PROBLEMA AO TENTAR CONSULTAR O BANCO DE DADOS");
		}

	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	public Date converterParaData(String txt) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = null;
		try {
			data = new java.sql.Date(format.parse(txt).getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return data ;

	}

}
