package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoCliente;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;

public class BusinessCliente implements IBusinessCliente {

	private static IDaoCliente dao;

	public BusinessCliente() {
		dao = new DaoCliente();
	}

	@Override
	public void salvarOuEditarCliente(Cliente cliente, Endereco endereco, String cep) throws BusinessException {
		try {
			validar(cliente);

			if (cliente.getId() == null) {
				dao.salvar(cliente, endereco, cep);
			} else {
				dao.editar(cliente);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public Cliente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validar(Cliente cliente) throws ValidacaoException {
		if (cliente == null) {
			throw new ValidacaoException("CLIENTE NÃO PODE SER INSERIDO");
		}

	}

}
