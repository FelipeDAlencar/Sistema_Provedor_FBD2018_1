package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessPorta {

	public void salvarOuEditar(Porta porta, String nomeSwitch) throws BusinessException;

	public ArrayList<Porta> listarTodos() throws BusinessException;

	public Porta buscarPorId(int id) throws BusinessException;

	public ArrayList<Porta> buscarPorBusca(String busca) throws BusinessException;
	
	public ArrayList<Porta> buscarPorSwitch(int switch_id) throws BusinessException;
	

}
