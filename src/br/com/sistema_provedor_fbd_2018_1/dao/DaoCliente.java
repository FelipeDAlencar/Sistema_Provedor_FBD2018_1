package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCliente implements IDaoCliente {
	private Connection connection;
	private PreparedStatement statement;

	@Override
	public void salvar(Cliente cliente) throws DaoException {
		try {
			
			this.connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			System.out.println(connection);
			this.statement = connection.prepareStatement(SQLUtil.Cliente.INSERT_ALL);
			System.out.println("Aqui");
			// statement.setString(Indice, valor);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getRg());
			statement.setString(4, cliente.getData_nascimento());

			statement.executeQuery();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO INSERIR UM CLIENTE - CONTACTE A EQUIPE RESPONSÁVEL");
		}

	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente buscarPorId(int id) throws DaoException {

		try {
			connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = connection.prepareStatement(SQLUtil.Cliente.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Cliente cliente = null;
			if (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			} else {
				throw new DaoException("CLIENTE NÃO CADASTRADO");
			}
			connection.close();
			return cliente;
		} catch (Exception e) {
			throw new DaoException("PROBLEMA AO TENTAR CONSULTAR O BANCO DE DADOS");
		}

	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
