package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoContato {
	
	public void salvar(Contato contato,String cpfCliente)throws DaoException;

	public void editar(Contato contato)throws DaoException;

	public  Contato buscarPorId(int id)throws DaoException;
	
	public ArrayList<Contato> listarTodos()throws DaoException;
	
	public List<Contato> buscarPorBusca(String busca);

}
