package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;

public interface IDaoEndereco {

	public void salvar(Endereco endereco);

	public void editar(Endereco endereco);

	public Endereco buscarPorId(int id);

	public List<Endereco> buscarPorBusca(String busca);

}
