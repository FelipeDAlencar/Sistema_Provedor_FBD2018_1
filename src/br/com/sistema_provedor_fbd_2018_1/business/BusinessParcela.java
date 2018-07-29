package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoParcela;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoParcela;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessParcela implements IBusinessParcela {
	private IDaoParcela dao;

	public BusinessParcela() {
		dao = new DaoParcela();
	}

	@Override
	public void salvarOuEditar(Parcela parcela) throws BusinessException {
		try {
			validar(parcela);
			if (parcela.getId() == null) {
				dao.salvar(parcela);
			} else {
				dao.editar(parcela);
			}
		} catch (DaoException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Parcela buscarPorId(int id) throws BusinessException {

		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

	@Override
	public ArrayList<Parcela> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	public void validar(Parcela parcela) throws BusinessException {
		if (parcela.getValor() == null) {
			throw new BusinessException("ADICIONE O VALOR A PARCELA");
		}
	}

	@Override
	public ArrayList<Parcela> listarTodos()throws BusinessException {

		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

}
