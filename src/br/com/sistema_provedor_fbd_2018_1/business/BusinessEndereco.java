package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoEndereco;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoEndereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;

public class BusinessEndereco implements IBusinessEndereco {
	
	IDaoEndereco dao;
	
	public BusinessEndereco() {
		dao = new DaoEndereco();
	}
	
	
	@Override
	public void salvarOuEditarEndereco(Endereco endereco)throws BusinessException {
		try {
			verificar(endereco);
			
			if(endereco.getId() == null) {
				
				dao.salvar(endereco);
			}else {
				dao.editar(endereco);
			}
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
		
		
	}

	@Override
	public Endereco buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Endereco> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void verificar(Endereco endereco) throws ValidacaoException{
		if(endereco.getRua().equals("") || endereco.getNumero() == 0) {
			throw new ValidacaoException("Erro de validação. Rua e numero devem ser preenchidos.");
		}
		
	}

}
