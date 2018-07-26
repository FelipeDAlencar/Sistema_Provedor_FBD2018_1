package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoFuncionario {

	public void salvar(Funcionario funcionario, Endereco endereco, String cep)throws DaoException;

	public void editar(Funcionario funcionario)throws DaoException;

	public Funcionario buscarPorId(int id)throws DaoException;

	public Funcionario buscarPorCpf(String cpf)throws DaoException;

	public ArrayList<Funcionario> buscarPorBusca(String busca)throws DaoException;
	
	public ArrayList<Funcionario> listarTodos()throws DaoException;
	
}
