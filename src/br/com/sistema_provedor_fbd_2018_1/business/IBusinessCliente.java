package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IBusinessCliente {
	
	
	public void salvarOuEditarCliente(Cliente cliente, Endereco endereco, String cep)throws BusinessException;

	public Cliente buscarPorId(int id)throws BusinessException, DaoException;

	public Cliente buscarPorCpf(String cpf) throws BusinessException;

	public List<Cliente> buscarPorBusca(String busca) throws BusinessException;


}
