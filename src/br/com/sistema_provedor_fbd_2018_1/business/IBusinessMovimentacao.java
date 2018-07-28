package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessMovimentacao {
	public void salvarOuEditar(Movimentacao movimentacao) throws BusinessException;

	public ArrayList<Movimentacao> listarTodos() throws BusinessException;

	public Movimentacao buscarPorId(int id) throws BusinessException;

	public ArrayList<Movimentacao> buscarPorBusca(String busca) throws BusinessException;


}
