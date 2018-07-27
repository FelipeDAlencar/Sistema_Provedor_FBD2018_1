package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoConcentrador;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoConcentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessConcentrador implements IBusinessConcentrador {

	IDaoConcentrador dao;

	public BusinessConcentrador() {
		dao = new DaoConcentrador();
	}

	@Override
	public void salvarOuEditar(Concentrador concentrador, String cep) throws BusinessException {
		try {
			validacao();

			if (concentrador.getId() == null) {
				dao.salvar(concentrador, cep);
			} else {
				dao.editar(concentrador);
			}
		} catch (Exception e) {
			try {

			} catch (Exception e2) {
				throw new BusinessException(e.getMessage());
			}
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Concentrador> listarTodos() throws BusinessException {

		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO LISTAR - BUS");
		}
	}

	@Override
	public Concentrador buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUCAR CONCENTRADOR - BUS");
		}
	}

	@Override
	public ArrayList<Concentrador> buscarPorBusca(String busca)throws BusinessException {
		
		try {
			return dao.buscarPorBusca(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

}
