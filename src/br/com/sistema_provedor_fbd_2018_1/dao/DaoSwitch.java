package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoSwitch implements IDaoSwitch {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Switch switch1, String nomeCaixa, String nomeConcentrador) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_NOME);
			statement.setString(1, nomeCaixa);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int caixa_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Concentrador.SELECT_NOME);
			statement.setString(1, nomeConcentrador);
			resultSet = statement.executeQuery();
			resultSet.next();

			int con_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Switch.INSERT_ALL);

			statement.setString(1, switch1.getNome());
			statement.setInt(2, switch1.getNumero_de_portas());
			statement.setString(3, switch1.getIp());
			statement.setString(4, switch1.getLogin());
			statement.setString(5, switch1.getSenha());
			statement.setInt(6, caixa_id);
			statement.setInt(7, con_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR SWITCH - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Switch switch1) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Switch buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Switch> listarTodos() throws DaoException {

		try {
			statement = conexao.prepareStatement(SQLUtil.Switch.INSERT_ALL);
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			ArrayList<Switch> switchs = new ArrayList<>();
			Switch switch1 = new Switch();

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				switch1.setNome(resultSet.getString(1));
				switch1.setNumero_de_portas(resultSet.getInt(2));
				switch1.setIp(resultSet.getString(3));
				switch1.setLogin(resultSet.getString(4));
				switch1.setSenha(resultSet.getString(5));

				switchs.add(switch1);
			}
			return switchs;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR SWITCH'S");
		}

	}

	@Override
	public List<Switch> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
