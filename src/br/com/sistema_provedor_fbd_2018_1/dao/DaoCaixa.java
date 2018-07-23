package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCaixa implements IDaoCaixa {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Caixa caixa, String cidade) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_NOME);
			statement.setString(1, cidade);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cidade_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Caixa.INSERT_ALL);

			statement.setString(1, caixa.getNome());
			statement.setString(2, caixa.getLatitude());
			statement.setString(3, caixa.getLongitude());
			statement.setInt(4, cidade_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CAIXA - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Caixa caixa, String cidade) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_NOME);
			statement.setString(1, cidade);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cidade_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Caixa.UPDATE);

			statement.setString(1, caixa.getNome());
			statement.setString(2, caixa.getLatitude());
			statement.setString(3, caixa.getLongitude());
			statement.setInt(4, cidade_id);
			statement.setInt(5, caixa.getId());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AOEDITAR CAIXA - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public Caixa buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_ID);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			Caixa caixa;
			if(resultSet.next()) {
				caixa = new Caixa(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getInt(5));
			}else {
				throw new DaoException("CAIXA NÃO ENCONTRADA - DAO");
			}
			return caixa;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR CAIXA - DAO");
		}
	}

	@Override
	public ArrayList<Caixa> listarTodos() throws DaoException {
		try {
			conexao =  SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_ALL);

			ArrayList<Caixa> caixas =  new ArrayList<>();
			Caixa caixa;

			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				caixa = new Caixa(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), 
						resultSet.getInt(5));
				caixas.add(caixa);

			}
			conexao.close();
			return caixas;

		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR CAIXAS - DAO");
		}


	}

	@Override
	public List<Caixa> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
