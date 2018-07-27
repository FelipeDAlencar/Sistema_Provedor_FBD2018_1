package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoCaixa {
	
	public void salvar(Caixa caixa, String cep)throws DaoException;

	public void editar(Caixa caixa, String cidade)throws DaoException;

	public Caixa buscarPorId(int id)throws DaoException;
	
	public ArrayList<Caixa> listarTodos()throws DaoException;
	
	public ArrayList<Caixa> buscarPorBusca(String busca) throws DaoException;

}
