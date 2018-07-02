package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoEndereco {

	public void salvar(Endereco endereco)throws DaoException;

	public void editar(Endereco endereco)throws DaoException;

	public Endereco buscarPorId(int id)throws DaoException;

	public List<Endereco> buscarPorBusca(String busca)throws DaoException;

}
