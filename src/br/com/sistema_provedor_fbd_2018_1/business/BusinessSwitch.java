package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoSwitch;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoSwitch;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessSwitch implements IBusinessSwitch {

	private IDaoSwitch dao;

	public BusinessSwitch() {
		dao = new DaoSwitch();
	}

	@Override
	public void salvarOuEditar(Switch switch1, String nomeCaixa, String nomeConcentrador) throws BusinessException {
		try {
			validacao();

			if (switch1.getId() == null) {
				dao.salvar(switch1, nomeCaixa, nomeConcentrador);
			} else {
				dao.editar(switch1);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Switch> listarTodos() throws BusinessException {

		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Switch buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR SWITCH- BUS");
		}
	}

	@Override
	public ArrayList<Switch> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
