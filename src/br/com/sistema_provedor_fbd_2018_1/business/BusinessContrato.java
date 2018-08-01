package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoContrato;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoContrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class BusinessContrato implements IBusinessContrato {

	IDaoContrato dao;

	public BusinessContrato() {
		dao = new DaoContrato();
	}

	@Override
	public void salvarOuEditar(Contrato contrato, Parcela parcela) throws BusinessException {
		try {
			validacao();
			if (contrato.getId() == null) {
				dao.salvar(contrato, parcela);
			} else {
				dao.editar(contrato);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Contrato> listarTodos() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrato buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contrato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
