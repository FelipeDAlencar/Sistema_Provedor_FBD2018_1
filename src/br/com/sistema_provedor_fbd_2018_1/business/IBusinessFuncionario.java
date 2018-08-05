package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IBusinessFuncionario {

	public void salvarOuEditarFuncionario(Funcionario funcionario,Endereco endereco)throws BusinessException;

	public Funcionario buscarPorId(int id)throws BusinessException;

	public Funcionario buscarPorCpf(String cpf)throws BusinessException;

	public ArrayList<Funcionario> buscarPorBusca(String busca)throws BusinessException;
	
	public ArrayList<Funcionario> listarTodos()throws BusinessException;

}
