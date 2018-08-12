package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumPorta;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoPorta implements IDaoPorta {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Porta porta, String nomeSwitch) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Switch.SELECT_NOME);
			statement.setString(1, nomeSwitch);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int sw_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Porta.INSERT_ALL);

			statement.setInt(1, porta.getNumero());
			statement.setInt(2, sw_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR PORTA - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Porta porta) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Porta buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Porta.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();
				Porta porta = new Porta(resultSet.getInt("id"), resultSet.getInt("switch_id"),
						resultSet.getInt("numero"));
				

			return porta;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AAO BUSCAR PORTAS - DAO");
		}
	}

	@Override
	public ArrayList<Porta> buscarPorSwitchEStatus(int switch_id) throws DaoException {
		try {
			ArrayList<Porta> portas = new ArrayList<>();
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Porta.SELECT_SWITCH_STATUS);
			statement.setInt(1, switch_id);
			statement.setString(2, enumPorta.LIVRE.getStatus());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Porta porta = new Porta(resultSet.getInt("id"), resultSet.getInt("switch_id"),
						resultSet.getInt("numero"));
				portas.add(porta);
			}

			return portas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AAO BUSCAR PORTAS - DAO");
		}
	}

	@Override
	public ArrayList<Porta> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Porta> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Porta buscarPorSwitchNome(Integer switch_id, int numero) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Porta.SELECT_SWITCH_NOME);
			statement.setInt(1, switch_id);
			statement.setInt(2, numero);

			ResultSet resultSet = statement.executeQuery();
			Porta porta = null;
			if (resultSet.next()) {
				
				porta = new Porta(resultSet.getInt("id"), resultSet.getInt("switch_id"),
						resultSet.getInt("numero"));
			}
			conexao.close();
			return porta;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR PORTA - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}
	}

}
