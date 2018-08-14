package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumParcela;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoParcela implements IDaoParcela {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Parcela parcela) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);

			statement = conexao.prepareStatement(SQLUtil.Contrato.SELECT_MAXID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int contrato_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Parcela.INSERT_ALL);

			statement.setDouble(1, parcela.getValor());
			statement.setDate(2, Ultil.converterStringParaDataSQL(parcela.getData_vencimento()));
			statement.setString(3, parcela.getStatus().getStatus());
			statement.setInt(4, contrato_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR PARCELAS");
		}

	}

	@Override
	public void editar(Parcela parcela) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);

			statement = conexao.prepareStatement(SQLUtil.Parcela.UPDATE);

			statement.setString(1, parcela.getStatus().getStatus());
			statement.setInt(2, parcela.getId());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR PARCELAS");
		}
	}

	@Override
	public Parcela buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Parcela.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Parcela parcela;
			if (resultSet.next()) {
				parcela = new Parcela(resultSet.getInt("id"), resultSet.getInt("contrato_id"),
						resultSet.getDouble("valor"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_vencimento")),
						enumParcela.getEnum(resultSet.getString("status")));
			} else {
				throw new DaoException("PARCELA NÃO CADASTRADO");
			}

			conexao.close();
			return parcela;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTAR CONSULTAR O BANCO DE DADOS");
		}

	}

	@Override
	public ArrayList<Parcela> listarTodos() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Parcela.SELECT_ALL);

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Parcela> parcelas = new ArrayList<>();
			Parcela parcela;

			while (resultSet.next()) {
				parcela = new Parcela(resultSet.getInt("id"), resultSet.getInt("contrato_id"),
						resultSet.getDouble("valor"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_vencimento")),
						enumParcela.getEnum(resultSet.getString("status")));
				parcelas.add(parcela);
			}
			return parcelas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR PARCELAS.");
		}

	}

	@Override
	public ArrayList<Parcela> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcela> buscaPorContratoID(int contrato_id) throws DaoException {
		try{
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Parcela.SELECT_PORCOTRATOID);
			statement.setInt(1, contrato_id);
			
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Parcela> parcelas = new ArrayList<>();
			Parcela parcela;
			
			while(resultSet.next()) {
				parcela = new Parcela(
						resultSet.getInt("id"),
						contrato_id,
						resultSet.getDouble("valor"),
						Ultil.converterDataSQLParaString(resultSet.getDate("data_vencimento")),
						enumParcela.getEnum(resultSet.getString("status")));
				parcelas.add(parcela);
			
			}
			return parcelas;
			   
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR PARCELAS");
		}
	}

}
