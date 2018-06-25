package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;


import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessCliente {
	
	
	public void salvarOuEditarCliente(Cliente cliente)throws BusinessException;

	public Cliente buscarPorId(int id)throws BusinessException;

	public Cliente buscarPorCpf(String cpf);

	public ArrayList<Cliente> buscarPorBusca(String busca);


}
