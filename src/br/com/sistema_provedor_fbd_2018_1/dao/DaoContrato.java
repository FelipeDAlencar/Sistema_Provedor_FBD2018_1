package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoContrato implements IDaoContrato {
	private Connection concexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Contrato contrato) throws DaoException {
		try {
			ResultSet resultSet;
			concexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = concexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF);
			statement.setString(1, "108.590.464-43");

			resultSet = statement.executeQuery();
			resultSet.next();

			int cliente_id = resultSet.getInt(1);

			statement = concexao.prepareStatement(SQLUtil.Porta.SELECT_NUMERO);
			statement.setInt(1, 1);

			resultSet = statement.executeQuery();
			resultSet.next();

			int porta_id = resultSet.getInt(1);

			statement = concexao.prepareStatement(SQLUtil.Contrato.INSERT_ALL);

			statement.setDouble(1, contrato.getValo_instalacao());
			statement.setDouble(2, contrato.getValor_mensal());
			statement.setString(3, contrato.getLogin());
			statement.setString(4, contrato.getSenha());
			statement.setInt(5, contrato.getNumero_parcelas());
			statement.setInt(6, cliente_id);
			statement.setInt(7, porta_id);
			
			statement.execute();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTRAR INSERIR CONTRATO");
			
		}

	}

	@Override
	public void editar(Contrato contrato) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Contrato buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contrato> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
