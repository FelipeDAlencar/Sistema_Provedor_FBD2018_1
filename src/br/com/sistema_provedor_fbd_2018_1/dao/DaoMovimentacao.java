package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoMovimentacao implements IDaoMovimentacao {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Movimentacao movimentacao) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.INSERT_ALL);

			statement.setString(1, movimentacao.getDescricao());
			statement.setString(2, movimentacao.getSituacao());
			statement.setDouble(3, movimentacao.getValor());
			statement.setDate(4, Ultil.converterStringParaDataSQL(movimentacao.getData_movimentacao()));
			statement.setBoolean(5, movimentacao.isStatus());
			statement.setString(6, movimentacao.getTipo());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR MOVIMENTACAO.");
		}

	}

	@Override
	public void editar(Movimentacao movimentacao) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.UPDATE);

			statement.setString(1, movimentacao.getDescricao());
			statement.setString(2, movimentacao.getSituacao());
			statement.setDouble(3, movimentacao.getValor());
			statement.setDate(4, Ultil.converterStringParaDataSQL(movimentacao.getData_movimentacao()));
			statement.setString(5, movimentacao.getTipo());
			statement.setInt(6, movimentacao.getId());

			statement.execute();

			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR MOVIMENTA합ES.");
		}

	}

	@Override
	public Movimentacao buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.SELECT_ID);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Movimentacao movimentacao = null;
			if (resultSet.next()) {
				movimentacao = new Movimentacao(resultSet.getInt("id"), resultSet.getString("descricao"),
						resultSet.getString("situacao"), resultSet.getString("tipo"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_movimentacao")),
						resultSet.getDouble("valor"), resultSet.getBoolean("status"));

			}
			return movimentacao;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR MOVIMENTA플O.");
		}

	}

	@Override
	public ArrayList<Movimentacao> listarTodos() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.SELECT_ALL);

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Movimentacao> movimentacaos = new ArrayList<>();
			Movimentacao movimentacao;

			while (resultSet.next()) {
				movimentacao = new Movimentacao(resultSet.getInt("id"), resultSet.getString("descricao"),
						resultSet.getString("situacao"), resultSet.getString("tipo"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_movimentacao")),
						resultSet.getDouble("valor"), resultSet.getBoolean("status"));
				movimentacaos.add(movimentacao);
			}
			return movimentacaos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR TODOS AS MOVIMENTA합ES");
		}
	}

	@Override
	public ArrayList<Movimentacao> buscarPorBusca(String busca, String situacao) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.SELECT_PORBUSCA);

			statement.setString(2, '%' + busca + '%');
			statement.setString(1, situacao);

			System.out.println(situacao);
			System.out.println();

			ResultSet resultSet = statement.executeQuery();

			ArrayList<Movimentacao> movimentacaos = new ArrayList<>();
			Movimentacao movimentacao;

			while (resultSet.next()) {
				movimentacao = new Movimentacao(resultSet.getInt("id"), resultSet.getString("descricao"),
						resultSet.getString("situacao"), resultSet.getString("tipo"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_movimentacao")),
						resultSet.getDouble("valor"), resultSet.getBoolean("status"));

				System.out.println(movimentacao.getSituacao());

				movimentacaos.add(movimentacao);
			}
			return movimentacaos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR MOVIMENTA합ES.");
		}

	}

	@Override
	public ArrayList<Movimentacao> buscarPago() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.SELECT_PAGO);

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Movimentacao> movimentacaos = new ArrayList<>();
			Movimentacao movimentacao;
			while (resultSet.next()) {
				movimentacao = new Movimentacao(resultSet.getInt("id"), resultSet.getString("descricao"),
						resultSet.getString("situacao"), resultSet.getString("tipo"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_movimentacao")),
						resultSet.getDouble("valor"), resultSet.getBoolean("status"));
				movimentacaos.add(movimentacao);
			}
			return movimentacaos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR MOVIMENTA합ES.");
		}

	}

	public ArrayList<Movimentacao> buscarNaoPago() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Movimentacao.SELECT_NAOPAGO);

			ResultSet resultSet = statement.executeQuery();

			ArrayList<Movimentacao> movimentacaos = new ArrayList<>();
			Movimentacao movimentacao;
			while (resultSet.next()) {
				movimentacao = new Movimentacao(resultSet.getInt("id"), resultSet.getString("descricao"),
						resultSet.getString("situacao"), resultSet.getString("tipo"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_movimentacao")),
						resultSet.getDouble("valor"), resultSet.getBoolean("status"));
				movimentacaos.add(movimentacao);
			}
			return movimentacaos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR MOVIMENTA합ES.");
		}

	}

}
