package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoConcentrador;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoConcentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class BusinessConcentrador implements IBusinessConcentrador {

	IDaoConcentrador dao;

	public BusinessConcentrador() {
		dao = new DaoConcentrador();
	}

	@Override
	public void salvarOuEditar(Concentrador concentrador,String cep) throws BusinessException {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caixa buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Concentrador> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
