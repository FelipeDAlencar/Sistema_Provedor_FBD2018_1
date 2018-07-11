package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoContato implements IDaoContato{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Contato contato,String cpfCliente) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF);
			statement.setString(1, cpfCliente);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cliente_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Contato.INSERT_ALL);

			statement.setString(1, contato.getTipo());
			statement.setString(2, contato.getContato());
			statement.setInt(5, cliente_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CONTATO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

		
	}

	@Override
	public void editar(Contato contato) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contato> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
