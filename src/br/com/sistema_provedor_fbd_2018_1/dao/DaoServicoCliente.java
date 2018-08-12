package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumPorta;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoServicoCliente implements IDaoServicoCliente {

	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(ServicoCliente servicoCliente) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			int endereco_id;
			statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ID_GETNOME);
			statement.setInt(1, servicoCliente.getServico_id());

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String descricao = servicoCliente.getCliente_id()+" "+resultSet.getString(1)+" Login: "+servicoCliente.getLogin();

			if(servicoCliente.getEndereco()!=null) {
				statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
				statement.setInt(1, servicoCliente.getEndereco().getNumero());
				statement.setString(2, servicoCliente.getEndereco().getRua());
				statement.setString(3, servicoCliente.getEndereco().getBairro());
				statement.setInt(4, servicoCliente.getEndereco().getCidade_id());
				statement.setString(5, servicoCliente.getEndereco().getComplemento());
				statement.execute();

				this.statement = conexao.prepareStatement(SQLUtil.Endereco.MAXID);
				resultSet = statement.executeQuery();
				resultSet.next();
				endereco_id = resultSet.getInt(1);
			}else {
				endereco_id = servicoCliente.getEndereco_id();
			}

			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.INSERT_ALL);

			statement.setInt(1, servicoCliente.getServico_id());
			statement.setInt(2, servicoCliente.getSwitch_id());
			statement.setInt(3, servicoCliente.getPorta_id());
			statement.setInt(4, endereco_id);
			statement.setInt(5, servicoCliente.getCliente_id());
			statement.setString(6, servicoCliente.getLogin());
			statement.setString(7, servicoCliente.getSenha());
			statement.setString(8, descricao);
			statement.execute();

			statement = conexao.prepareStatement(SQLUtil.Porta.UPDATE);
			statement.setString(1, enumPorta.OCUPADA.getStatus());
			statement.setInt(2, servicoCliente.getPorta_id());

			statement.execute();
			conexao.close();

		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR SERVICO");
		}


	}

	@Override
	public void editar(ServicoCliente servicoCliente) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServicoCliente buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.SELECT_ID);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			ServicoCliente servico = new ServicoCliente(
					resultSet.getInt("id"),
					resultSet.getInt("servico_id"),
					resultSet.getInt("switch_id"),
					resultSet.getInt("porta_id"),
					resultSet.getInt("endereco_id"),
					resultSet.getInt("cliente_id"),
					resultSet.getString("login"),
					resultSet.getString("senha"),
					resultSet.getString("descricao"));


			conexao.close();
			return servico;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVICO - DAO");
		}


	}

	@Override
	public ArrayList<ServicoCliente> listarTodos() throws DaoException {
		try {
			conexao =  SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.SELECT_ALL);
			ResultSet resultSet = statement.executeQuery();
			ArrayList<ServicoCliente> servicoClientes = new ArrayList<>();
			ServicoCliente servicoCliente;

			while(resultSet.next()) {
				servicoCliente =  new ServicoCliente(
						resultSet.getInt("id"),
						resultSet.getInt("servico_id"), 
						resultSet.getInt("switch_id"), 
						resultSet.getInt("porta_id"),
						resultSet.getInt("endereco_id"),
						resultSet.getString("login"),
						resultSet.getString("senha"),
						resultSet.getString("descricao"));
				servicoClientes.add(servicoCliente);
			}
			return servicoClientes;

		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO OO LISTAR SERVICOS");
		}
	}

	@Override
	public ArrayList<ServicoCliente> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicoCliente> buscarPorCliente(Integer cliente_id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.SELECT_CLIENTE);

			statement.setInt(1, cliente_id);

			ResultSet resultSet = statement.executeQuery();
			List<ServicoCliente> servicos = new ArrayList<>();
			while (resultSet.next()) {
				ServicoCliente servicoCliente = new ServicoCliente(
						resultSet.getInt("id"),
						resultSet.getInt("servico_id"),
						resultSet.getInt("switch_id"),
						resultSet.getInt("porta_id"),
						resultSet.getInt("endereco_id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("login"),
						resultSet.getString("senha"),
						resultSet.getString("descricao"));

				servicos.add(servicoCliente);
			}
			conexao.close();
			return servicos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVICO - DAO");
		}
	}

	@Override
	public int buscarPorDescricao(String descricao) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.SELECT_DESCRICAO);
			
			statement.setString(1,descricao);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			conexao.close();
			
			return resultSet.getInt(1);
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVICO - DAO");
		}
	}

}
