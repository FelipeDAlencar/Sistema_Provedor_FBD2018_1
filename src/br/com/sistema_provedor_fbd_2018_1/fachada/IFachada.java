package br.com.sistema_provedor_fbd_2018_1.fachada;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IFachada {

	// Cliente
	public void salvarOuEditarCliente(Cliente cliente, Endereco endereco, String cep) throws BusinessException;

	public Cliente buscarClientePorId(int id) throws BusinessException;

	public Cliente buscarClientePorCpf(String cpf);

	public List<Cliente> buscarClientePorBusca(String busca) throws BusinessException;

	// Endereco
	public void salvarOuEditarEndereco(Endereco endereco) throws BusinessException;

	public Endereco buscarEnderecoPorId(int id) throws BusinessException;

	public ArrayList<Endereco> buscarEnderecoPorBusca(String busca);

	// Funcionario
	public void salvarOuEditarFuncionario(Funcionario funcionario, Endereco endereco, String cep) throws BusinessException;

	public Funcionario buscarFuncionarioPorId(int id) throws BusinessException;

	public Funcionario buscarPorCpf(String cpf)throws BusinessException;

	public ArrayList<Funcionario> buscarFuncionarioPorBusca(String busca)throws BusinessException;
	
	public ArrayList<Funcionario> listarTodosFuncionarios() throws BusinessException;

	// Cidade

	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException;

	public Cidade buscarCidadePorId(int id) throws BusinessException;

	public ArrayList<Cidade> buscarCidadePorBusca(String busca) throws BusinessException;

	public ArrayList<Cidade> listarTodosCidades() throws BusinessException;
	public Cidade buscarPorNomeEstado(String nome, String estado)throws BusinessException;
	

	// Atendimento
	public void salvarOuEditarAtendimento(Atendimento atendimento, String cpfCliente) throws BusinessException;

	public ArrayList<Atendimento> listarTodosAtendimento() throws BusinessException;

	public Atendimento buscarAtendimentoPorId(int id) throws BusinessException;

	public ArrayList<Atendimento> buscarAtendimentoPorBusca(String busca) throws BusinessException;

	// Caixa
	public void salvarOuEditarCaixa(Caixa caixa, String cep) throws BusinessException;

	public ArrayList<Caixa> listarTodosCaixa() throws BusinessException;

	public Caixa buscarCaixaPorId(int id) throws BusinessException;

	public ArrayList<Caixa> buscarCaixaPorBusca(String busca) throws BusinessException;

	// Concentrador
	public void salvarOuEditarConcentrador(Concentrador concentrador, String cep) throws BusinessException;

	public ArrayList<Concentrador> listarTodosConcentrador() throws BusinessException;

	public Concentrador buscarConcentradorPorId(int id) throws BusinessException;

	public ArrayList<Concentrador> buscarConcentradorPorBusca(String busca) throws BusinessException;

	// Contato
	public void salvarOuEditarContato(Contato contato, String cpfCliente) throws BusinessException;

	public ArrayList<Contato> listarTodosContato() throws BusinessException;

	public Contato buscarContatoPorId(int id) throws BusinessException;

	public ArrayList<Contato> buscarContatoPorBusca(String busca);

	// Contrato
	public void salvarOuEditarContrato(Contrato contrato,Parcela parcela) throws BusinessException;

	public ArrayList<Contrato> listarTodosContrato() throws BusinessException;

	public Contrato buscarContratoPorId(int id) throws BusinessException;

	public ArrayList<Contrato> buscarContratoPorBusca(String busca);

	public ArrayList<Contrato> buscarContratoPorClienteID(int cliente_id) throws BusinessException;
	// Porta
	public void salvarOuEditarPorta(Porta porta, String nomeSwitch) throws BusinessException;

	public ArrayList<Porta> listarTodosPorta() throws BusinessException;

	public Porta buscarPortaPorId(int id) throws BusinessException;
	
	public ArrayList<Porta> buscarPortaPorSwitch(int switch_id) throws BusinessException;
	
	public ArrayList<Porta> buscarPortaPorBusca(String busca);

	// Servico
	public void salvarOuEditarServico(Servico servico) throws BusinessException;

	public ArrayList<Servico> listarTodosServico() throws BusinessException;

	public Servico buscarServicoPorId(int id) throws BusinessException;

	public ArrayList<Servico> buscarServicoPorBusca(String busca) throws BusinessException;

	// Switch
	public void salvarOuEditarSwitch(Switch switch1, String nomeCaixa, String nomeConcentrador) throws BusinessException;

	public ArrayList<Switch> listarTodosSwitch() throws BusinessException;

	public Switch buscarSwitchPorId(int id) throws BusinessException;

	public ArrayList<Switch> buscarSwitchPorBusca(String busca) throws BusinessException;
	
	public Switch buscarSwitchPorNome(String nome) throws BusinessException;
	
	//MOVIMENTACAO
	public void salvarOuEditarMovimentacao(Movimentacao movimentacao) throws BusinessException;

	public ArrayList<Movimentacao> listarTodosMovimentacao() throws BusinessException;

	public Movimentacao buscarPorIdMovimentacao(int id) throws BusinessException;

	public ArrayList<Movimentacao> buscarPorBuscaMovimentacao(String busca) throws BusinessException;
	
	
	//PARCELA
	public void salvarOuEditar(Parcela parcela)throws BusinessException;

	public Parcela buscarPorId(int id)throws BusinessException;

	public ArrayList<Parcela> listarTodos() throws BusinessException;
	public ArrayList<Parcela> buscarParcelaPorBusca(String busca);
	public ArrayList<Parcela> buscarParcelaPorContratoID(int contrato_id)throws BusinessException;
	
	
	Servico buscarServicoNome(String nome) throws BusinessException;

	Porta buscarPortaPorSwitchNumero(Integer switch_id, int numero) throws BusinessException;
	
	
	//SERVICO CLIENTE
	public void salvarOuEditarServicoCliente(ServicoCliente servicoCliente) throws BusinessException;
	public ArrayList<ServicoCliente> listarTodosServicosCliente()throws BusinessException;

	public ServicoCliente buscarServicosClientesPorId(int id) throws BusinessException;

	//public ArrayList<ServicoCliente> buscarPorBusca(String busca)throws BusinessException;

}
