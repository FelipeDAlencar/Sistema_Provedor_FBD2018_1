package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoEndereco implements IDaoEndereco {
	private Connection connection;
	private PreparedStatement statement;

	@Override
	public void salvar(Endereco endereco) throws DaoException {
		try {
			connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = connection.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
			
			
			statement.setInt(1, endereco.getNumero());
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getBairro());
			statement.setInt(4, endereco.getCidade_id());
			
			statement.execute();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTAR INSERIR ENDERECO NO BANCO DE DADOS - CONTATE A EQUIPE RESPOSÁVEL - DAO");
		}
	}

	@Override
	public void editar(Endereco endereco)throws DaoException {
		
		try {
			connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = connection.prepareStatement(SQLUtil.Endereco.UPDATE);
			
			statement.setInt(1, endereco.getNumero());
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getBairro());
			statement.setInt(4, endereco.getCidade_id());
			statement.setString(5, endereco.getComplemento());
			statement.setInt(6, endereco.getId());

			statement.execute();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

	@Override
	public Endereco buscarPorId(int id) throws DaoException {

		try {
			connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = connection.prepareStatement(SQLUtil.Endereco.SELECT_ID);
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			Endereco endereco;

			if (resultSet.next()) {
				endereco = new Endereco(resultSet.getInt("id"), resultSet.getString("bairro"), resultSet.getString("complemento"),
						resultSet.getString("rua"), resultSet.getInt("numero"), resultSet.getInt("cidade_id"));
			}else {
				throw new DaoException("ENDERECO NÃO CADASTRADO");
			}
			return endereco;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR ENDERECO - DAO");
		}

	}

	@Override
	public List<Endereco> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
