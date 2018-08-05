package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessServicoCliente {
	


	
	public void salvarOuEditar(ServicoCliente servicoCliente) throws BusinessException;
	public ArrayList<ServicoCliente> listarTodos()throws BusinessException;

	public ServicoCliente buscarPorId(int id) throws BusinessException;

	public ArrayList<ServicoCliente> buscarPorBusca(String busca)throws BusinessException;
	
	public List<ServicoCliente> bucarPorCliente(Integer cliente_id) throws BusinessException;

}
