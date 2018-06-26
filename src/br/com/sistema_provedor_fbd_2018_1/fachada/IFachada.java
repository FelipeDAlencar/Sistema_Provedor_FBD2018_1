package br.com.sistema_provedor_fbd_2018_1.fachada;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IFachada {

	// Cliente
	public void salvarOuEditarCliente(Cliente cliente) throws BusinessException;

	public Cliente buscarClientePorId(int id) throws BusinessException;

	public Cliente buscarClientePorCpf(String cpf);

	public ArrayList<Cliente> buscarClientePorBusca(String busca);

	// Endereco
	public void salvarOuEditarEndereco(Cliente cliente) throws BusinessException;

	public Endereco buscarEnderecoPorId(int id) throws BusinessException;

	public ArrayList<Endereco> buscarEnderecoPorBusca(String busca);

	// Funcionario
	public void salvarOuEditarFuncionario(Cliente cliente) throws BusinessException;

	public Funcionario buscarPorId(int id) throws BusinessException;

	public Funcionario buscarPorCpf(String cpf);

	public ArrayList<Funcionario> buscarPorBusca(String busca);

	// Cidade

	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException;

	public Cidade buscarCidadePorId(int id) throws BusinessException;

	public ArrayList<Cidade> buscarCidadePorBusca(String busca);

	public ArrayList<Cidade> listarTodosCidades()throws BusinessException;

}
