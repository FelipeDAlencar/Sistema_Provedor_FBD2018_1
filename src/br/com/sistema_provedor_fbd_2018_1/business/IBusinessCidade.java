package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessCidade {
	

	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException;

	public Cidade buscarPorId(int id) throws BusinessException;

	public ArrayList<Cidade> buscarPorBusca(String busca);

}
