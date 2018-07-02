package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCidade implements IDaoCidade {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Cidade cidade) throws DaoException {

		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.INSERT_ALL);

			statement.setString(1, cidade.getNome());
			statement.setString(2, cidade.getEstado());
			statement.setString(3, cidade.getCep());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CIDADE - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Cidade cidade) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.UPDATE);
			
			
			
			
			statement.setString(1, cidade.getNome());
			statement.setString(2, cidade.getEstado());
			statement.setString(3, cidade.getCep());
			statement.setInt(4, cidade.getId());
			
			statement.execute();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR CIDADE - DAO");
		}

	}

	@Override
	public ArrayList<Cidade> listarTodos() throws DaoException {
		conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
		try {
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_ALL);
			ArrayList<Cidade> cidades = new ArrayList<>();

			ResultSet resultSet = statement.executeQuery();
			Cidade cidade;
			while (resultSet.next()) {
				cidade = new Cidade(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				cidades.add(cidade);

			}
			return cidades;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CONSULTAR O BANCO DE DADOS.");

		}
	}

	@Override
	public Cidade buscarPorId(int id) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Cidade cidade;

			if (resultSet.next()) {
				cidade = new Cidade(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			} else {
				throw new DaoException("CIDADE NÃO CADASTRADO");
			}

			conexao.close();
			return cidade;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTAR CONSULTAR O BANCO DE DADOS");
		}

	}


	@Override
	public List<Cidade> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
