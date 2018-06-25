package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;

public interface IBusinessFuncionario {

	public void salvarOuEditarFuncionario(Cliente cliente);

	public Funcionario buscarPorId(int id);

	public Funcionario buscarPorCpf(String cpf);

	public ArrayList<Funcionario> buscarPorBusca(String busca);

}
