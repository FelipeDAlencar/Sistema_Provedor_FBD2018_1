package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessServico {

	public void salvarOuEditar(Servico servico) throws BusinessException;

	public ArrayList<Servico> listarTodos() throws BusinessException;

	public Servico buscarPorId(int id) throws BusinessException;

	public ArrayList<Servico> buscarPorBusca(String busca) throws BusinessException;

	public Servico buscarPorNome(String nome) throws BusinessException;

}
