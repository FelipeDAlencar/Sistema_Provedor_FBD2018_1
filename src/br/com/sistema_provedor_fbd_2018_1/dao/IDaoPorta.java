package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoPorta {

	public void salvar(Porta porta, String nomeSwitch) throws DaoException;

	public void editar(Porta porta) throws DaoException;

	public Porta buscarPorId(int id) throws DaoException;

	public ArrayList<Porta> listarTodos() throws DaoException;

	public ArrayList<Porta> buscarPorBusca(String busca)throws DaoException;

	public ArrayList<Porta> buscarPorSwitchEStatus(int switch_id)throws DaoException;

	public Porta buscarPorSwitchNome(Integer switch_id, int numero) throws DaoException;

}
