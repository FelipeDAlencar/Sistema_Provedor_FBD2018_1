package br.com.fbd_2018_1;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Caixa;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Contato;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Porta;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Servico;

public class App {
	public static void main(String[] args) throws BusinessException {

		Fachada fachada = new Fachada();
		
		Contrato contrato = new Contrato(0, 0, "Teste", "Teste", 0);
		fachada.salvarOuEditarContrato(contrato);
		
		// br.com.sistema_provedor_fbd_2018_1.entidade.Porta porta = new
		// br.com.sistema_provedor_fbd_2018_1.entidade.Porta(1);
		// fachada.salvarOuEditarPorta(porta);
		
		// Switch switch1 = new Switch("Teste", "Teste", "Teste", "Teste", 0);
		// fachada.salvarOuEditarSwitch(switch1);
		
		// Concentrador concentrador = new Concentrador("Teste", "Teste", "Teste",
		// "Teste");
		// fachada.salvarOuEditarConcentrador(concentrador);
		
		// br.com.sistema_provedor_fbd_2018_1.entidade.Caixa caixa = new
		// br.com.sistema_provedor_fbd_2018_1.entidade.Caixa("C1", "0", "0");
		// fachada.salvarOuEditarCaixa(caixa);
		
		// br.com.sistema_provedor_fbd_2018_1.entidade.Contato contato = new
		// br.com.sistema_provedor_fbd_2018_1.entidade.Contato("Teste", "Teste",
		// "Teste", "Teste");
		// fachada.salvarOuEditarContato(contato);
		
		// br.com.sistema_provedor_fbd_2018_1.entidade.Servico servico = new
		// br.com.sistema_provedor_fbd_2018_1.entidade.Servico("Teste", 0 , 0);
		//
		// fachada.salvarOuEditarServico(servico);
		
		//br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento atendimento = new br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento("Teste", "Teste2");
		//fachada.salvarOuEditarAtendimento(atendimento);
		// Funcionario funcionario = new Funcionario("Yannes", "Garoto de programa",
		// "10/10/2010", "admin", "123");

		// fachada.salvarOuEditarFuncionario(funcionario);

		// Endereco endereco = new Endereco("Centro","Mercadinho Cobal", "Rua Murilo
		// Fagundes", 56);
		//
		// fachada.salvarOuEditarEndereco(endereco);
		//
		//
		// Cliente cliente = new Cliente("Felipe", "108.590.464-43", "9.116.815",
		// "21/10/1998");
		//
		//
		// fachada.salvarOuEditarCliente(cliente);

		//
		// Cidade cidade = fachada.buscarCidadePorId(2);

		// cidade.setCep("100000");
		// cidade.setNome("Serra Taiada");
		// cidade.setEstado("PE");

		// cidade.setNome("Serra Talhada");
		//
		// fachada.salvarOuEditarCidade(cidade);

		// System.out.println(fachada.buscarCidadePorId(9).getNome() + "\n");

		// for (Cidade cidade2 : fachada.listarTodosCidades()) {
		// System.out.println(cidade2.getNome());
		// }

	}

}
