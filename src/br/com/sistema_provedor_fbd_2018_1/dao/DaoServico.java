package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoServico implements IDaoServico {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Servico servico) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.INSERT_ALL);

			statement.setString(1, servico.getNome());
			statement.setInt(2, servico.getDownload());
			statement.setInt(3, servico.getUpload());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR SERVICO- CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Servico servico) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.UPDATE);

			statement.setString(1, servico.getNome());
			statement.setInt(2, servico.getDownload());
			statement.setInt(3, servico.getUpload());
			statement.setInt(4, servico.getId());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR SERVIÇO - CONTATE A EQUIPE (DAO)");
		}

	}

	@Override
	public Servico buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ID);

			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			Servico servico;

			if (resultSet.next()) {
				servico = new Servico(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4));

			} else {
				throw new DaoException("SERVIÇO NÃO CADASTRADO");
			}
			conexao.close();
			return servico;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVIÇO - CONTATE A EQUIPE (DAO)");
		}

	}

	@Override
	public ArrayList<Servico> listarTodos() throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL);

			ArrayList<Servico> servicos = new ArrayList<>();
			Servico servico;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				servico = new Servico(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4));
				servicos.add(servico);
			}
			conexao.close();
			return servicos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR TODOS OS  CONCENTRADORES");
		}

	}

	@Override
	public ArrayList<Servico> buscarPorBusca(String busca) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_PORBUSCA);

			statement.setString(1, '%' + busca + '%');

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Servico> servicos = new ArrayList<>();
			Servico servico;

			while (resultSet.next()) {
				servico = new Servico(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getInt("upload"),
						resultSet.getInt("download"));
				servicos.add(servico);
			}
			return servicos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVICO");
		}

	}

	@Override
	public Servico buscarPorNome(String nome) throws DaoException {
		try {
			
			
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_NOME);

			statement.setString(1, nome);
			
			ResultSet resultSet = statement.executeQuery();
			Servico servico = null;

			if (resultSet.next()) {
			
				servico = new Servico(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getInt("download"),
						resultSet.getInt("upload"));
				
			}

			return servico;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SERVICO");
		}
	}

}
