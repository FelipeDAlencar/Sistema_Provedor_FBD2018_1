package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoSwitch {
	
	public void salvar(Switch switch1, String nomeCaixa)throws DaoException;

	public void editar(Switch switch1)throws DaoException;

	public Switch buscarPorId(int id)throws DaoException;
	
	public ArrayList<Switch> listarTodos()throws DaoException;
	
	public List<Switch> buscarPorBusca(String busca);

}
