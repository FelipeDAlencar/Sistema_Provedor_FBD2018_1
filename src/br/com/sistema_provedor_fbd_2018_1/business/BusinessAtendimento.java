package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;

public class BusinessAtendimento implements IBusinessAtendimento {

	IDaoAtendimento dao;

	public BusinessAtendimento() {
		dao = new DaoAtendimento();
	}

	@Override
	public void salvarOuEditar(Atendimento atendimento, String cpfCliente) throws BusinessException {
		try {
			validacao();
			if (atendimento.getId() == null) {
				dao.salvar(atendimento, cpfCliente);
			} else {
				dao.editar(atendimento, cpfCliente);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public ArrayList<Atendimento> listarTodos() throws BusinessException {
		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("");
		}
	}

	@Override
	public Atendimento buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atendimento> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validacao() throws ValidacaoException {
		// TODO Auto-generated method stub

	}
}
