package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoConcentrador implements IDaoConcentrador {
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Concentrador concentrador, String cep) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_CEP);
			statement.setString(1, cep);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cidade_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Concentrador.INSERT_ALL);


			statement.setString(1, concentrador.getNome());
			statement.setString(2, concentrador.getIp());
			statement.setString(3, concentrador.getLogin());
			statement.setString(4, concentrador.getSenha());
			statement.setInt(5, cidade_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CONCENTRADOR - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

		
	}

	@Override
	public void editar(Concentrador concentrador) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Concentrador buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Concentrador> listarTodos() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement =  conexao.prepareStatement(SQLUtil.Concentrador.SELECT_ALL);
			
			ArrayList<Concentrador> concentradors = new ArrayList<>();
			Concentrador concentrador;
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				concentrador =  new Concentrador(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				concentradors.add(concentrador);
			}
			
			return concentradors;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR TODOS OS  CONCENTRADORES");
		}
			
		
	}

	@Override
	public List<Concentrador> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
