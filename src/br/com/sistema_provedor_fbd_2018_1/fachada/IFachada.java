package br.com.sistema_provedor_fbd_2018_1.fachada;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public interface IFachada {

	// Cliente
	public void salvarOuEditarCliente(Cliente cliente) throws BusinessException;

	public Cliente buscarClientePorId(int id) throws BusinessException;

	public Cliente buscarClientePorCpf(String cpf);

	public ArrayList<Cliente> buscarClientePorBusca(String busca);

	// Endereco
	public void salvarOuEditarEndereco(Endereco endereco) throws BusinessException;

	public Endereco buscarEnderecoPorId(int id) throws BusinessException;

	public ArrayList<Endereco> buscarEnderecoPorBusca(String busca);

	// Funcionario
	public void salvarOuEditarFuncionario(Funcionario funcionario) throws BusinessException;

	public Funcionario buscarPorId(int id) throws BusinessException;

	public Funcionario buscarPorCpf(String cpf);

	public ArrayList<Funcionario> buscarPorBusca(String busca);

	// Cidade

	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException;

	public Cidade buscarCidadePorId(int id) throws BusinessException;

	public ArrayList<Cidade> buscarCidadePorBusca(String busca);

	public ArrayList<Cidade> listarTodosCidades() throws BusinessException;

	// Atendimento
	public void salvarOuEditarAtendimento(Atendimento atendimento, String cpfCliente) throws BusinessException;

	public ArrayList<Atendimento> listarTodosAtendimento() throws BusinessException;

	public Atendimento buscarAtendimentoPorId(int id) throws BusinessException;

	public ArrayList<Atendimento> buscarAtendimentoPorBusca(String busca);

	// Caixa
	public void salvarOuEditarCaixa(Caixa caixa, String cep) throws BusinessException;

	public ArrayList<Caixa> listarTodosCaixa() throws BusinessException;

	public Caixa buscarCaixaPorId(int id) throws BusinessException;

	public ArrayList<Caixa> buscarCaixaPorBusca(String busca);

	// Concentrador
	public void salvarOuEditarConcentrador(Concentrador concentrador, String cep) throws BusinessException;

	public ArrayList<Concentrador> listarTodosConcentrador() throws BusinessException;

	public Concentrador buscarConcentradorPorId(int id) throws BusinessException;

	public ArrayList<Concentrador> buscarConcentradorPorBusca(String busca);

	// Contato
	public void salvarOuEditarContato(Contato contato, String cpfCliente) throws BusinessException;

	public ArrayList<Contato> listarTodosContato() throws BusinessException;

	public Contato buscarContatoPorId(int id) throws BusinessException;

	public ArrayList<Contato> buscarContatoPorBusca(String busca);

	// Contrato
	public void salvarOuEditarContrato(Contrato contrato, String cpfCliente, int numeroPorta) throws BusinessException;

	public ArrayList<Contrato> listarTodosContrato() throws BusinessException;

	public Contrato buscarContratoPorId(int id) throws BusinessException;

	public ArrayList<Contrato> buscarContratoPorBusca(String busca);

	// Porta
	public void salvarOuEditarPorta(Porta porta, String nomeSwitch) throws BusinessException;

	public ArrayList<Porta> listarTodosPorta() throws BusinessException;

	public Porta buscarPortaPorId(int id) throws BusinessException;

	public ArrayList<Porta> buscarPortaPorBusca(String busca);

	// Servico
	public void salvarOuEditarServico(Servico servico) throws BusinessException;

	public ArrayList<Servico> listarTodosServico() throws BusinessException;

	public Servico buscarServicoPorId(int id) throws BusinessException;

	public ArrayList<Servico> buscarServicoPorBusca(String busca);

	// Switch
	public void salvarOuEditarSwitch(Switch switch1, String nomeCaixa) throws BusinessException;

	public ArrayList<Switch> listarTodosSwitch() throws BusinessException;

	public Switch buscarvPorId(int id) throws BusinessException;

	public ArrayList<Switch> buscarSwitchPorBusca(String busca);
}
