package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumAtendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoAtendimento implements IDaoAtendimento {

	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Atendimento atendimento) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);

			statement = conexao.prepareStatement(SQLUtil.Atendimento.INSERT_ALL);

			statement.setInt(1, atendimento.getCliente_id());
			statement.setString(2, atendimento.getMotivo());
			statement.setDate(3, Ultil.converterStringParaDataSQL(atendimento.getData_atendimento()));
			statement.setString(4, atendimento.getStatus().getStatus());
			statement.setInt(5, atendimento.getServico_id());
			statement.setString(6, atendimento.getDescricao());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR ATENDIMENTO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public void editar(Atendimento atendimento) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);

			statement = conexao.prepareStatement(SQLUtil.Atendimento.UPDATE);
			statement.setString(1, atendimento.getStatus().getStatus());
			statement.setDate(2, Ultil.converterStringParaDataSQL(atendimento.getData_atendimento()));
			statement.setInt(3, atendimento.getId());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR ATENDIMENTO - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

	}

	@Override
	public Atendimento buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Atendimento.SELECT_ID);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			Atendimento atendimento;

			resultSet.next();
				atendimento = new Atendimento(
						resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("motivo"),
						resultSet.getString("data_atendimento"),
						enumAtendimento.getEnum(resultSet.getString("status")),
						resultSet.getInt("servico_id"),
						resultSet.getString("descricao"));
				return atendimento;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR ATENDIMENTOS POR CLIENTE");
		}

	}

	@Override
	public ArrayList<Atendimento> listarTodos() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Atendimento.SELECT_ALL);

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Atendimento> atendimentos = new ArrayList<>();
			Atendimento atendimento;

			while (resultSet.next()) {
				atendimento = new Atendimento(
						resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("motivo"),
						resultSet.getString("data_atendimento"),
						enumAtendimento.getEnum(resultSet.getString("status")),
						resultSet.getInt("servico_id"),
						resultSet.getString("descricao"));

				atendimentos.add(atendimento);

			}

			return atendimentos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR ATENDIMENTOS");
		}
	}

	@Override
	public ArrayList<Atendimento> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atendimento> buscarAtrasados(String data) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Atendimento.SELECT_ATRASADOS);
			statement.setDate(1, Ultil.converterStringParaDataSQL(data));

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Atendimento> atendimentos = new ArrayList<>();
			Atendimento atendimento;

			while (resultSet.next()) {
				atendimento = new Atendimento(
						resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("motivo"),
						resultSet.getString("data_atendimento"),
						enumAtendimento.getEnum(resultSet.getString("status")),
						resultSet.getInt("servico_id"),
						resultSet.getString("descricao"));
				atendimentos.add(atendimento);
			}

			return atendimentos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR ATENDIMENTOS EM ATRASO");
		}

	}

	@Override
	public List<Atendimento> buscarPorCliente(Integer cliente_id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Atendimento.SELECT_CLIENTE);
			statement.setInt(1, cliente_id);
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Atendimento> atendimentos = new ArrayList<>();
			Atendimento atendimento;

			while (resultSet.next()) {
				atendimento = new Atendimento(
						resultSet.getInt("id"),
						resultSet.getInt("cliente_id"),
						resultSet.getString("motivo"),
						resultSet.getString("data_atendimento"),
						enumAtendimento.getEnum(resultSet.getString("status")),
						resultSet.getInt("servico_id"),
						resultSet.getString("descricao"));

				atendimentos.add(atendimento);

			}

			return atendimentos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR ATENDIMENTOS POR CLIENTE");
		}

	}

}
