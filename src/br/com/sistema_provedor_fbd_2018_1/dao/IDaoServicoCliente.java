package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoServicoCliente {
	public void salvar(ServicoCliente servicoCliente)throws DaoException;

	public void editar(ServicoCliente servicoCliente)throws DaoException;

	public ServicoCliente buscarPorId(int id)throws DaoException;
	
	public ArrayList<ServicoCliente> listarTodos()throws DaoException;
	
	public ArrayList<ServicoCliente> buscarPorBusca(String busca) throws DaoException;

	public List<ServicoCliente> buscarPorCliente(Integer cliente_id) throws DaoException;
	


}
