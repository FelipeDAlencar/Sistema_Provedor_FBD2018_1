package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoEndereco implements IDaoEndereco {
	private Connection connection;
	private PreparedStatement statement;
	
	
	
	@Override
	public void salvar(Endereco endereco)throws DaoException {
		
		try {
			connection = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = connection.prepareStatement(SQLUtil.Cidade.MAXID);
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int cidade_id = resultSet.getInt(1);
			
			statement = connection.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
			
			statement.setInt(1, endereco.getNumero());
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getBairro());
			statement.setInt(4, cidade_id);
			
			
			statement.execute();
			
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTAR INSERIR ENDERECO NO BANCO DE DADOS");
		}
		
	}
	@Override
	public void editar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Endereco buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Endereco> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
