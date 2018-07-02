package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;


import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessContrato {

	public void salvarOuEditar(Contrato contrato) throws BusinessException;

	public ArrayList<Contrato> listarTodos() throws BusinessException;

	public Contrato buscarPorId(int id) throws BusinessException;

	public ArrayList<Contrato> buscarPorBusca(String busca);

}
