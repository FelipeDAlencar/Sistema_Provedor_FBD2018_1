package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoAtendimento {
	
	public void salvar(Atendimento atendimento, String cpfCliente)throws DaoException;

	public void editar(Atendimento atendimento, String cpfCliente)throws DaoException;

	public Atendimento buscarPorId(int id)throws DaoException;
	
	public ArrayList<Atendimento> listarTodos()throws DaoException;
	
	public ArrayList<Atendimento> buscarPorBusca(String busca);

}
