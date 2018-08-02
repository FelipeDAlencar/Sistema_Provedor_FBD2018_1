package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoParcela{
	public void salvar(Parcela parcela)throws DaoException;

	public void editar(Parcela parcela)throws DaoException;

	public Parcela buscarPorId(int id)throws DaoException;
	
	public ArrayList<Parcela> listarTodos()throws DaoException;
	
	public ArrayList<Parcela> buscarPorBusca(String busca) throws DaoException;
	
	public ArrayList<Parcela> buscaPorContratoID(int contrato_id)throws DaoException;


}
