package br.com.sistema_provedor_fbd_2018_1.fachada;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.business.BusinessCidade;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessCliente;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessEndereco;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessCidade;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessCliente;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessEndereco;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class Fachada implements IFachada{
	private static Fachada fachada;
	
	IBusinessCliente businessCliente;
	IBusinessEndereco businessEndereco;
	IBusinessFuncionario businessFuncionario;
	IBusinessCidade businessCidade;
	
	
	
	public Fachada() {
		businessCliente =  new BusinessCliente();
		businessEndereco = new BusinessEndereco();
		businessFuncionario = new BusinessFuncionario();
		businessCidade = new BusinessCidade();
		
	}
	
	public static Fachada getInstance() {
		if(fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}
	@Override
	public void salvarOuEditarCliente(Cliente cliente) throws BusinessException{
		this.businessCliente.salvarOuEditarCliente(cliente);
		
	}
	@Override
	public Cliente buscarClientePorId(int id)throws BusinessException {
		
		return this.buscarClientePorId(id);
	}

	@Override
	public Cliente buscarClientePorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> buscarClientePorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarOuEditarEndereco(Cliente cliente) throws BusinessException{
		
		
	}

	@Override
	public Endereco buscarEnderecoPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Endereco> buscarEnderecoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarOuEditarFuncionario(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	@Override
	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException {
		businessCidade.salvarOuEditarCidade(cidade);
		
	}

	@Override
	public Cidade buscarCidadePorId(int id) throws BusinessException {
		return businessCidade.buscarPorId(id);
	}

	@Override
	public ArrayList<Cidade> buscarCidadePorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
