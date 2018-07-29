package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.dao.DaoCliente;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
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
	public Cliente buscarPorId(int id) throws DaoException {
		return dao.buscarPorId(id);
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarPorBusca(String busca) throws BusinessException {
		try {
			return dao.buscarPorBusca(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR CLIENTE");
			
		}
	}

	private void validar(Cliente cliente) throws ValidacaoException {
		if (cliente == null) {
			throw new ValidacaoException("CLIENTE NÃO PODE SER INSERIDO");
		}

	}

}
