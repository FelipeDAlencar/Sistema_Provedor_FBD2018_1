package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessServicoCliente implements IBusinessServicoCliente {

	private IDaoServicoCliente dao;

	public BusinessServicoCliente() {
		dao = new DaoServicoCliente();
	}

	@Override
	public void salvarOuEditar(ServicoCliente servicoCliente) throws BusinessException {
		try {
			if (servicoCliente.getId() == null) {

				dao.salvar(servicoCliente);

			} else {
				dao.editar(servicoCliente);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ServicoCliente> listarTodos() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicoCliente buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ServicoCliente> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicoCliente> bucarPorCliente(Integer cliente_id) throws BusinessException {
		try {
			return dao.buscarPorCliente(cliente_id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR SERVICO - BUS");
		}
	}

}
