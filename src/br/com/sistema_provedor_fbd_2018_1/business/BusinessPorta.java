package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoPorta;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoPorta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessPorta implements IBusinessPorta {

	IDaoPorta dao;

	public BusinessPorta() {
		dao = new DaoPorta();
	}

	@Override
	public void salvarOuEditar(Porta porta, String nomeSwitch) throws BusinessException {
		try {
			validacao();

			if (porta.getId() == null) {
				dao.salvar(porta, nomeSwitch);

			} else {
				dao.editar(porta);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Porta> listarTodos() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Porta buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR PORTA POR ID - DAO");
		}
	}

	@Override
	public ArrayList<Porta> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Porta> buscarPorSwitch(int switch_id) throws BusinessException {
		try {
			return dao.buscarPorSwitchEStatus(switch_id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR PORTAS CONTATE A EQUIPE RESPONSAVEL - BUS");
		}
	}

	@Override
	public Porta buscarPorSwitchNome(Integer switch_id, int numero) throws BusinessException {
		try {
			return dao.buscarPorSwitchNome(switch_id, numero);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR PORTAS CONTATE A EQUIPE RESPONSAVEL - BUS");
		}
	}

}
