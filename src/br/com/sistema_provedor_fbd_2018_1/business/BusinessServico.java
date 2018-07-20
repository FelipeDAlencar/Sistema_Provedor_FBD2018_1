package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;


import br.com.sistema_provedor_fbd_2018_1.dao.DaoServico;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoServico;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessServico implements IBusinessServico{


	private IDaoServico dao;

	public BusinessServico() {
		dao =  new DaoServico();
	}


	@Override
	public void salvarOuEditar(Servico servico) throws BusinessException {
		try {
			validacao();

			if(servico.getId() == null) {
				dao.salvar(servico);
			}else {
				dao.editar(servico);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Servico> listarTodos() throws BusinessException {
		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO LISTAR SERVIÇOS - BUS");
		}
	}

	@Override
	public Servico buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

	@Override
	public ArrayList<Servico> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
