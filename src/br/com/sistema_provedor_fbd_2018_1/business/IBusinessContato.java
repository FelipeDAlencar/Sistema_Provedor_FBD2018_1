package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessContato {

	public void salvarOuEditar(Contato contato, String cpfCliente) throws BusinessException;

	public ArrayList<Contato> listarTodos() throws BusinessException;

	public Contato buscarPorId(int id) throws BusinessException;

	public ArrayList<Contato> buscarPorBusca(String busca)  throws BusinessException;;

	public List<Contato> buscarPorCliente(Integer cliente_id)  throws BusinessException;;

}
