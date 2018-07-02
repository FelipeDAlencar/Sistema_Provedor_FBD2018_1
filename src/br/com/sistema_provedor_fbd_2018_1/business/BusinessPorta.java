package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoPorta;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoPorta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class BusinessPorta implements IBusinessPorta{

	IDaoPorta dao;
	public BusinessPorta() {
		dao = new DaoPorta();
	}
	
	@Override
	public void salvarOuEditar(Porta porta) throws BusinessException {
		try {
			validacao();
			
			if(porta.getId() == null) {
				dao.salvar(porta);
				
			}else {
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
		return null;
	}

	@Override
	public ArrayList<Porta> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
