package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Funcionario funcionario, Endereco endereco, String cep) {

		conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
		try {

			
			//CIDADE
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_CEP);
			statement.setString(1, cep);
			
			ResultSet resultSet1 = statement.executeQuery();
			resultSet1.next();
			int cidade_id = resultSet1.getInt(1);
			
			System.out.println("ID CIDADE:" + cidade_id);
			
			//ENDERECO
			statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
			statement.setInt(1, endereco.getNumero());
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getBairro());
			statement.setInt(4, cidade_id);
			statement.execute();	
			
			this.statement = conexao.prepareStatement(SQLUtil.Endereco.MAXID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int endereco_id = resultSet.getInt(1);
			
			
			
			
			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);

			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCargo());
			statement.setDate(3, BusinessFuncionario.converterParaData(funcionario.getData_contrato()));
			statement.setString(4, funcionario.getLogin());
			statement.setString(5, funcionario.getSenha());
			statement.setInt(6, endereco_id);

			statement.execute();

			conexao.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editar(Funcionario funcionario) {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.UPDATE);

			
			
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCargo());
			statement.setDate(3, BusinessFuncionario.converterParaData(funcionario.getData_contrato()));
			statement.setString(4, funcionario.getLogin());
			statement.setString(5, funcionario.getSenha());
			statement.setInt(6, funcionario.getEndereco_id());
			statement.setInt(7, funcionario.getId());
			
			statement.execute();
			conexao.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public Funcionario buscarPorId(int id)throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ID);
			
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			Funcionario funcionario;
			
			if(resultSet.next()) {
				funcionario =  new Funcionario(resultSet.getInt(1), resultSet.getInt(7), resultSet.getString(2), resultSet.getString(3),String.valueOf(resultSet.getDate(4)),
						resultSet.getString(5),resultSet.getString(6));
				
			}else {
				throw new DaoException("FUNCIONARIO NÃO CADASTRADO");
			}
			
			
			return funcionario;
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTAR BUSCAR FUNCIONARIO - DAO");
		}

	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> listarTodos() throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ALL);

			ArrayList<Funcionario> funcionarios = new ArrayList<>();
			Funcionario funcionario;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				funcionario = new Funcionario(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						String.valueOf(resultSet.getDate(4)), resultSet.getString(5), resultSet.getString(6));

				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR OS FUNCIONARIOS.");
		}
	}

	
}
