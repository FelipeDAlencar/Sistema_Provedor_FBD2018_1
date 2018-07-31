package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoServicoCliente implements IDaoServicoCliente {
	
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(ServicoCliente servicoCliente) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.ServicoCliente.INSERT_ALL);
			
			statement.setInt(1, servicoCliente.getServico_id());
			statement.setInt(2, servicoCliente.getSwitch_id());
			statement.setInt(3, servicoCliente.getPorta_id());
			statement.setInt(4, servicoCliente.getEndereco_id());
			
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
		// TODO Auto-generated method stub
		return null;
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
				servicoCliente =  new ServicoCliente(resultSet.getInt("id"), resultSet.getInt("servico_id"), resultSet.getInt("switch_id"), 
						resultSet.getInt("porta_id"), resultSet.getInt("endereco_id"));
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

}
