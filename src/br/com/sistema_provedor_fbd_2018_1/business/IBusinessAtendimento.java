package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessAtendimento {

	public void salvarOuEditar(Atendimento atendimentos) throws BusinessException;

	public ArrayList<Atendimento> listarTodos() throws BusinessException;

	public Atendimento buscarPorId(int id) throws BusinessException;

	public ArrayList<Atendimento> buscarPorBusca(String busca);
	
	public ArrayList<Atendimento> buscarAtendimentosAtrasados(String data) throws BusinessException;

	public List<Atendimento> buscarPorCliente(Integer cliente_id)throws BusinessException;


}
