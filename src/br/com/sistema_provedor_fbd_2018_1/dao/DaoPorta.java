package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Porta> buscarPorSwitch(int switch_id) throws DaoException {
		try {
			ArrayList<Porta> portas = new ArrayList<>();
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Porta.SELECT_SWITCH);
			statement.setInt(1, switch_id);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Porta porta = new Porta(resultSet.getInt("id"), resultSet.getInt("numero"), resultSet.getInt("switch_id"));
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

}
