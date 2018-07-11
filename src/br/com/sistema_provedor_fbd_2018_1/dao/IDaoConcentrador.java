package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoConcentrador {
	
	public void salvar(Concentrador concentrador, String cep)throws DaoException;

	public void editar(Concentrador concentrador)throws DaoException;

	public Concentrador buscarPorId(int id)throws DaoException;
	
	public ArrayList<Concentrador> listarTodos()throws DaoException;
	
	public List<Concentrador> buscarPorBusca(String busca);

}
