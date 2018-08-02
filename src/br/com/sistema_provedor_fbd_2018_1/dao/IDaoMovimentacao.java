package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;


public interface IDaoMovimentacao {
	
	public void salvar(Movimentacao movimentacao)throws DaoException;

	public void editar(Movimentacao movimentacao)throws DaoException;

	public Movimentacao buscarPorId(int id)throws DaoException;
	
	public ArrayList<Movimentacao> listarTodos()throws DaoException;
	
	public ArrayList<Movimentacao> buscarPorBusca(String busca, String situacao) throws DaoException;

	public ArrayList<Movimentacao> buscarPago() throws DaoException;
	
	public ArrayList<Movimentacao> buscarNaoPago() throws DaoException;

}
