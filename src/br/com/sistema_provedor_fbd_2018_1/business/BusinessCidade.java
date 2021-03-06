package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoCidade;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoCidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;

public class BusinessCidade implements IBusinessCidade {

	IDaoCidade dao;

	public BusinessCidade() {
		dao = new DaoCidade();
	}

	@Override
	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException {
		try {
			validarCidade(cidade);

			if (cidade.getId() == null) {
				dao.salvar(cidade);
			} else {
				dao.editar(cidade);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}
	@Override
	public ArrayList<Cidade> listarTodos()throws BusinessException  {
		try {
			return dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERRO DO BUSINESS");
			
		}
	}

	@Override
	public Cidade buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public ArrayList<Cidade> buscarPorBusca(String busca)throws BusinessException {
		try {
			return dao.buscarPorBusca(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NOS BUS - CIDADE");
		}
	}
	public Cidade buscarPorNomeEstado(String nome, String estado)throws BusinessException {
		try {
			return dao.buscarPorNomeEstado(nome, estado);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}
	public void excluir(int id, boolean status)throws BusinessException {
		try {
			dao.excluir(id, status);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	public void validarCidade(Cidade cidade) throws ValidacaoException {
		if (cidade.getCep() == null || cidade.getCep().equals("")) {
			throw new ValidacaoException("CERTIFIQUE-SE DE QUE O CEP SEJA PREENCHIDO");
		}
	}



}
