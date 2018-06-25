package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;

public interface IDaoFuncionario {

	public void salvar(Funcionario funcionario);

	public void editar(Funcionario funcionario);

	public Funcionario buscarPorId(int id);

	public Funcionario buscarPorCpf(String cpf);

	public List<Funcionario> buscarPorBusca(String busca);

}
