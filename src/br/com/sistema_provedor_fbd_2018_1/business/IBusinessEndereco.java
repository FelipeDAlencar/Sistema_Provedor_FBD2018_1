package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessEndereco {

	public void salvarOuEditarEndereco(Endereco endereco)throws BusinessException;

	public Endereco buscarPorId(int id)throws BusinessException;
	
	public ArrayList<Endereco> buscarPorBusca(String busca)throws BusinessException;

}
