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
			statement.setBoolean(3, cidade.isStatus());
			statement.setString(4, cidade.getCep());
			
			
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
			statement.setBoolean(4, cidade.isStatus());
			statement.setInt(5, cidade.getId());

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
				cidade = new Cidade(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("estado"),
						resultSet.getString("cep"), resultSet.getBoolean("status"));
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
				cidade = new Cidade(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("estado"),
						resultSet.getString("cep"), resultSet.getBoolean("status"));

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
	public ArrayList<Cidade> buscarPorBusca(String busca) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_PORBUSCA);

			statement.setString(1, '%' + busca + '%');
			statement.setString(2, '%' + busca + '%');
			statement.setString(3, '%' + busca + '%');

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Cidade> cidades = new ArrayList<>();
			Cidade cidade;
			while (resultSet.next()) {
				cidade = new Cidade(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("estado"),
						resultSet.getString("cep"), resultSet.getBoolean("status"));

				cidades.add(cidade);
			}

			return cidades;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR CIDADE");
		}
	}

	@Override
	public Cidade buscarPorNomeEstado(String nome, String estado) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_NOMEESTADO);
			statement.setString(1, nome);
			statement.setString(2, estado);

			ResultSet resultSet = statement.executeQuery();
			Cidade cidade = null;
			if (resultSet.next()) {
				cidade = new Cidade(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("estado"),
						resultSet.getString("cep"), resultSet.getBoolean("status"));


			} else {
				System.out.println("Entrou else");
			}
			return cidade;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao buscar cidade.");
		}

	}

}
