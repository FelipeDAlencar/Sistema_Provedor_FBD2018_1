package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCliente implements IDaoCliente {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Cliente cliente, Endereco endereco, String cep) throws DaoException {
		try {
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);

			// CIDADE
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_CEP);
			statement.setString(1, cep);

			ResultSet resultSet1 = statement.executeQuery();
			resultSet1.next();
			int cidade_id = resultSet1.getInt(1);

			

			// ENDERECO
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

			// CLIENTE
			statement = conexao.prepareStatement(SQLUtil.Cliente.INSERT_ALL);
			// statement.setString(Indice, valor);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getRg());
			statement.setDate(4, Ultil.converterParaData(cliente.getData_nascimento()));
			statement.setInt(5, endereco_id);

			statement.execute();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO INSERIR UM CLIENTE - CONTACTE A EQUIPE RESPONSÁVEL");
		}

	}

	@Override
	public void editar(Cliente cliente)throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.UPDATE);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getRg());
			statement.setDate(4, Ultil.converterParaData(cliente.getData_nascimento()));
			statement.setInt(5, cliente.getEndereco_id());
			statement.setInt(6, cliente.getId());

			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO ATUALIZAR CLIENTE.");
		}

	}

	public ArrayList<Atendimento> listarTodos() throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_ALL);
			ArrayList<Atendimento> atendimetos = new ArrayList<>();

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Atendimento atendimento = new Atendimento(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(4));
				atendimetos.add(atendimento);

			}

			conexao.close();
			return atendimetos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO CONSULTAR O BANCO DE DADOS.");

		}
	}

	@Override
	public Cliente buscarPorId(int id) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Cliente cliente;
			if (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("rg"),Ultil.converterDataParaString(resultSet.getDate("data_nascimento")), resultSet.getInt("endereco_id"));
			} else {
				throw new DaoException("CLIENTE NÃO CADASTRADO");
			}
			conexao.close();
			return cliente;
		} catch (Exception e) {
			throw new DaoException("PROBLEMA AO TENTAR CONSULTAR O BANCO DE DADOS");
		}

	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_PORBUSCA);
			statement.setString(1, '%' + busca + '%');

			ResultSet resultSet = statement.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente cliente;

			while (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getInt("endereco_id"));
				clientes.add(cliente);
			}
			return clientes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR CLIENTES");
		}


	}

}
