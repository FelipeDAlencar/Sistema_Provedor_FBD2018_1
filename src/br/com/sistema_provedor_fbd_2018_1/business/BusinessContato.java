package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoContato;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoContato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class BusinessContato implements IBusinessContato {

	private IDaoContato dao;

	public BusinessContato() {
		dao = new DaoContato();
	}

	@Override
	public void salvarOuEditar(Contato contato) throws BusinessException {
		try {
			validacao();

			if (contato.getId() == null) {
				dao.salvar(contato);
			} else {
				dao.editar(contato);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Contato> listarTodos() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
