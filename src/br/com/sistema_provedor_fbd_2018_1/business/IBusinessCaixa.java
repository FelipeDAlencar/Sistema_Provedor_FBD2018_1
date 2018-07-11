package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessCaixa {

	public void salvarOuEditar(Caixa caixa, String cep) throws BusinessException;

	public ArrayList<Caixa> listarTodos() throws BusinessException;

	public Caixa buscarPorId(int id) throws BusinessException;

	public ArrayList<Caixa> buscarPorBusca(String busca);

}
