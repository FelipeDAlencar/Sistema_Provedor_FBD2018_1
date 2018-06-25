package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;

public interface IBusinessEndereco {

	public void salvarOuEditarEndereco(Cliente cliente);

	public Endereco buscarPorId(int id);
	
	public ArrayList<Endereco> buscarPorBusca(String busca);

}
