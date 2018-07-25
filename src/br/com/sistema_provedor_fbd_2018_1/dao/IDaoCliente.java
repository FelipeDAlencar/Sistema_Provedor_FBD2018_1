package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.List;


import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoCliente {

	public void salvar(Cliente cliente, Endereco endereco, String cep)throws DaoException;

	public void editar(Cliente cliente, Endereco endereco);

	public Cliente buscarPorId(int id)throws DaoException;

	public Cliente buscarPorCpf(String cpf);

	public List<Cliente> buscarPorBusca(String busca);
	
	

}
