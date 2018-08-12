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

public class DaoContato implements IDaoContato {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Contato contato, String cpfCliente) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF);
			statement.setString(1, cpfCliente);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cliente_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Contato.INSERT_ALL);

			statement.setString(1, contato.getResponsavel());
			statement.setString(2, contato.getTipo());
			statement.setString(3, contato.getContato());
			statement.setInt(4, cliente_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CONTATO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Contato contato) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contato.UPDATE);

			statement.setString(1, contato.getResponsavel());
			statement.setString(2, contato.getTipo());
			statement.setString(3, contato.getContato());
			statement.setInt(4, contato.getId());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR CONTATO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}


	}

	@Override
	public Contato buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contato.SELECT_ID);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			Contato contato = null;
			if (resultSet.next()) {
				contato = new Contato(resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(1));
			}
			return contato;
		} catch (SQLException e) {
			throw new DaoException("ERRO AO RETORNAR CONTATO POR ID");
		}

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

	@Override
	public List<Contato> buscarPorCliente(Integer cliente_id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contato.SELECT_CLIENTE);
			List<Contato> contatos= new ArrayList<>();
			statement.setInt(1, cliente_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contato contato = new Contato(resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("responsavel"),
						resultSet.getString("tipo"),
						resultSet.getString("contato"));
				contatos.add(contato);
			}
			conexao.close();
			return contatos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CARREGAR CONTATOS");

		}
	}

	@Override
	public Contato buscarPorContato(String contato) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contato.SELECT_CONTATO);
			statement.setString(1, contato);
			ResultSet resultSet = statement.executeQuery();
			Contato cont = null;
			if (resultSet.next()) {
				cont = new Contato(resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("responsavel"),
						resultSet.getString("tipo"),
						resultSet.getString("contato"));

			}
			System.out.println(cont.getContato());
			conexao.close();
			return cont;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CARREGAR CONTATOS");

		}
	}

}
