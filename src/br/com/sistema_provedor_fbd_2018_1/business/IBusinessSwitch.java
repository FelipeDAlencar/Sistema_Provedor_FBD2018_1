package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessSwitch {
	
	public void salvarOuEditar(Switch switch1, String nomeCaixa, String nomeConcentrador) throws BusinessException;

	public ArrayList<Switch> listarTodos() throws BusinessException;

	public Switch buscarPorId(int id) throws BusinessException;

	public ArrayList<Switch> buscarPorBusca(String busca);

}
