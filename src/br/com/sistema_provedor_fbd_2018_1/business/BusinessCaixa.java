package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoCaixa;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoCaixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessCaixa implements IBusinessCaixa {

	private IDaoCaixa dao;

	public BusinessCaixa() {
		dao = new DaoCaixa();
	}

	@Override
	public void salvarOuEditar(Caixa caixa, String cep) throws BusinessException {
		try {
			validacao();

			if (caixa.getId() == null) {
				dao.salvar(caixa, cep);
			} else {
				dao.editar(caixa);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Caixa> listarTodos() throws BusinessException {

		try {
			return dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO LISTAR CAIXAS - BUS");
		}

	}

	@Override
	public Caixa buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Caixa> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
