package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IBusinessAtendimento {

	public void salvarOuEditar(Atendimento atendimento, String cpfCliente) throws BusinessException;

	public ArrayList<Atendimento> listarTodos() throws BusinessException;

	public Atendimento buscarPorId(int id) throws BusinessException;

	public ArrayList<Atendimento> buscarPorBusca(String busca);
	
	public ArrayList<Atendimento> buscarAtendimentosAtrasados(String data) throws BusinessException;

}
