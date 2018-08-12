package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoContrato implements IDaoContrato {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Contrato contrato, Parcela parcela) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contrato.INSERT_ALL);

			statement.setDouble(1, contrato.getValor_instalacao());
			statement.setDouble(2, contrato.getValor_mensal());
			statement.setInt(5, contrato.getNumero_parcelas());
			statement.setInt(6, contrato.getCliente_id());

			statement.execute();

			statement = conexao.prepareStatement(SQLUtil.Contrato.SELECT_MAXID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int contrato_id = resultSet.getInt(1);
			
			
			statement = conexao.prepareStatement(SQLUtil.Parcela.INSERT_ALL);
			
			
		
			String dataAtual = Ultil.datasParcelas(parcela.getData_vencimento());
			
			
			for (int i = 0; i < contrato.getNumero_parcelas(); i++) {
				statement.setDouble(1, parcela.getValor());
				statement.setDate(2, Ultil.converterStringParaDataSQL(dataAtual));
				statement.setBoolean(3, parcela.isStatus());
				statement.setInt(4, contrato_id);
				statement.execute();
				dataAtual =  Ultil.datasParcelas(dataAtual);

			}

			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO TENTRAR INSERIR CONTRATO");

		}

	}

	@Override
	public void editar(Contrato contrato) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Contrato buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contrato> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contrato> buscarPorClienteID(int cliente_id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Contrato.SELECT_PORCLIENTE_ID);
			statement.setInt(1, cliente_id);

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Contrato> contratos = new ArrayList<>();
			Contrato contrato;

			while (resultSet.next()) {
				contrato = new Contrato(
						resultSet.getInt("id"),
						cliente_id,
						resultSet.getDouble("valor_instalacao"),
						resultSet.getDouble("valor_mensal"),
						resultSet.getInt("servico_id"),
						resultSet.getInt("numero_parcelas"));
				contratos.add(contrato);
			}
			return contratos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CONSULTAR CONTRATOS");
		}

	}

}
