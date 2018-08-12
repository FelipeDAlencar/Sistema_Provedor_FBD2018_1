package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoCidade {
	
	public void salvar(Cidade cidade)throws DaoException;

	public void editar(Cidade cidade)throws DaoException;

	public Cidade buscarPorId(int id)throws DaoException;
	
	public ArrayList<Cidade> listarTodos()throws DaoException;
	
	public ArrayList<Cidade> buscarPorBusca(String busca) throws DaoException;
	
	public Cidade buscarPorNomeEstado(String nome, String cidade)throws DaoException;
	
	public void excluir(int id, boolean status)throws DaoException;

}
