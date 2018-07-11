package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessConcentrador {

	public void salvarOuEditar(Concentrador concentrador,String cep) throws BusinessException;

	public ArrayList<Concentrador> listarTodos() throws BusinessException;

	public Caixa buscarPorId(int id) throws BusinessException;

	public ArrayList<Concentrador> buscarPorBusca(String busca);

}
