package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoAtendimento implements IDaoAtendimento {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Atendimento atendimento, String cpfCliente) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF);
			statement.setString(1, cpfCliente);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cliente_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Atendimento.INSERT_ALL);

			statement.setString(1, atendimento.getMotivo());
			statement.setString(2, atendimento.getProtocolo());
			statement.setInt(3, cliente_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR ATENDIMENTO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Atendimento atendimento, String cpfCliente) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Atendimento buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atendimento> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atendimento> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
