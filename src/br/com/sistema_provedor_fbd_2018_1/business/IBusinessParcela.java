package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;


import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;


public interface IBusinessParcela {
	
	public void salvarOuEditar(Parcela parcela)throws BusinessException;

	public Parcela buscarPorId(int id)throws BusinessException;

	
	public ArrayList<Parcela> buscarPorBusca(String busca);

	
	

}
