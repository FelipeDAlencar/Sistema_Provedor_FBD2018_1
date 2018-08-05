package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Funcionario funcionario, Endereco endereco) throws DaoException {

		conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
		try {
			// ENDERECO
			statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
			statement.setInt(1, endereco.getNumero());
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getBairro());
			statement.setInt(4, endereco.getCidade_id());
			statement.setString(5, endereco.getComplemento());
			statement.execute();

			this.statement = conexao.prepareStatement(SQLUtil.Endereco.MAXID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int endereco_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);

			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCargo());
			statement.setDate(3, Ultil.converterParaData(funcionario.getData_contrato()));
			statement.setString(4, funcionario.getLogin());
			statement.setString(5, funcionario.getSenha());
			statement.setInt(6, endereco_id);

			statement.execute();

			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR FUNCIONÁRIO");
		}

	}

	@Override
	public void editar(Funcionario funcionario) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.UPDATE);

			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCargo());
			statement.setDate(3, Ultil.converterParaData(funcionario.getData_contrato()));
			statement.setString(4, funcionario.getLogin());
			statement.setString(5, funcionario.getSenha());
			statement.setInt(6, funcionario.getEndereco_id());
			statement.setInt(7, funcionario.getId());

			statement.execute();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR FUNCIONÁRIO");
		}

	}

	@Override
	public Funcionario buscarPorId(int id) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ID);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			Funcionario funcionario;

			if (resultSet.next()) {
				funcionario = new Funcionario(resultSet.getInt(1), resultSet.getInt(7), resultSet.getString(2),
						resultSet.getString(3), Ultil.converterDataParaString(resultSet.getDate(4)), resultSet.getString(5),
						resultSet.getString(6));

			} else {
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
	public ArrayList<Funcionario> buscarPorBusca(String busca) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_PORBUSCA);
			statement.setString(1, '%' + busca + '%');
			statement.setString(2, '%' + busca + '%');
			statement.setString(3, '%' + busca + '%');
			statement.setString(4, '%' + busca + '%');

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Funcionario> funcionarios = new ArrayList<>();
			Funcionario funcionario;

			while (resultSet.next()) {

				funcionario = new Funcionario(resultSet.getInt("id"), resultSet.getString("nome"),
						resultSet.getString("cargo"), Ultil.converterDataParaString(resultSet.getDate("data_contrato")),
						resultSet.getString("login"), resultSet.getString("senha"));
				funcionarios.add(funcionario);
			}
			return funcionarios;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR FUNCIONÁRIO.");
		}

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
						Ultil.converterDataParaString(resultSet.getDate(4)), resultSet.getString(5), resultSet.getString(6));

				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR OS FUNCIONARIOS.");
		}
	}

}
