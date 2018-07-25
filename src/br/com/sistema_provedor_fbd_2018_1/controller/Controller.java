package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalLocalizarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class Controller implements ActionListener {
	private boolean loop;
	private TelaPrincipal telaPrincipal;
	private Fachada fachada;
	private InternalCadastroCliente internalAdicionarCliente;
	private InternalFuncionario internalFuncionario;
	private InternalAtendimentos internalAtendimentos;
	private InternalSwitch internalSwitch;
	private InternalServicos internalServicos;
	private InternalCidade internalCidade;
	private InternalConcentrador internalConcentrador;
	private InternalCaixa internalCaixa;
	private InternalLocalizarCliente internalLocalizarCliente;
	private ControllerCliente controllerCadastroCliente;
	private ControllerFuncionario controllerFuncionario;
	private ControllerAtendimentos controllerAtendimentos;
	private ControllerSwitch controllerSwitch;
	private ControllerServico controllerServico;
	private ControllerCidade controllerCidade;
	private ControllerConcentrador controllerConcentrador;
	private ControllerCaixa controllerCaixa;
	private ControllerVisualizar controllerVisualizar;
	private ControllerCadastroSwitch controllerCadastroSwitch;
	private InternalCadastroSwitch internalCadastroSwitch;

	public Controller(TelaPrincipal telaPrincipal) {
		loop = true;
		
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;

		// Botoes desktop
		telaPrincipal.getBtnAdicionarCliente().addActionListener(this);
		telaPrincipal.getBtnVerCliente().addActionListener(this);
		telaPrincipal.getBtnAtendimentos().addActionListener(this);
		telaPrincipal.getBtnAdicionarSwitch().addActionListener(this);

		// Itens Menu Cadatro
		telaPrincipal.getMenu().getFuncionarioCadastro().addActionListener(this);
		telaPrincipal.getMenu().getServicoCadastro().addActionListener(this);
		telaPrincipal.getMenu().getCidadeCadastro().addActionListener(this);

		// itens Menu Cliente
		telaPrincipal.getMenu().getAdicionarCliente().addActionListener(this);
		telaPrincipal.getMenu().getVerCliente().addActionListener(this);
		telaPrincipal.getMenu().getAtendimentosCliente().addActionListener(this);

		// itens Menu Network
		telaPrincipal.getMenu().getConcentradorNetwork().addActionListener(this);
		telaPrincipal.getMenu().getSwitchNetwork().addActionListener(this);
		telaPrincipal.getMenu().getCaixaNetwork().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			telaPrincipal.desativarBotoes();
			if (e.getSource() == telaPrincipal.getBtnAdicionarCliente()
					|| e.getSource() == telaPrincipal.getMenu().getAdicionarCliente()) {
				controllerCadastroCliente = new ControllerCliente(telaPrincipal);
				internalAdicionarCliente = new InternalCadastroCliente(telaPrincipal, controllerCadastroCliente);
				telaPrincipal.getDesktopPane().add(internalAdicionarCliente);
				internalAdicionarCliente.setVisible(true);
				controllerCadastroCliente.setAdicionarCliente(internalAdicionarCliente);
				controllerCadastroCliente.addListeners();

			}

			if (e.getSource() == telaPrincipal.getBtnVerCliente()
					|| e.getSource() == telaPrincipal.getMenu().getVerCliente()) {
				controllerVisualizar = new ControllerVisualizar();
				internalLocalizarCliente = new InternalLocalizarCliente(telaPrincipal, controllerVisualizar);
				telaPrincipal.getDesktopPane().add(internalLocalizarCliente);
				internalLocalizarCliente.setVisible(true);
				controllerVisualizar.setInternalLocalizarCliente(internalLocalizarCliente);
				controllerVisualizar.addListeners();
			}
			if (e.getSource() == telaPrincipal.getBtnAtendimentos()
					|| e.getSource() == telaPrincipal.getMenu().getAtendimentosCliente()) {
				controllerAtendimentos = new ControllerAtendimentos();
				internalAtendimentos = new InternalAtendimentos(telaPrincipal, controllerAtendimentos);
				telaPrincipal.getDesktopPane().add(internalAtendimentos);
				internalAtendimentos.setVisible(true);
				controllerAtendimentos.setInternalAtendimentos(internalAtendimentos);
				controllerAtendimentos.addListeners();
			}

			if (e.getSource() == telaPrincipal.getMenu().getSwitchNetwork()) {
				controllerSwitch = new ControllerSwitch(telaPrincipal);
				internalSwitch = new InternalSwitch(telaPrincipal, controllerSwitch);
				telaPrincipal.getDesktopPane().add(internalSwitch);
				internalSwitch.carregarSwitchs(fachada.listarTodosSwitch());
				internalSwitch.setVisible(true);
				controllerSwitch.setInternalSwitch(internalSwitch);
				controllerSwitch.addListeners();
			}

			if (e.getSource() == telaPrincipal.getBtnAdicionarSwitch()) {
				controllerSwitch = new ControllerSwitch(telaPrincipal);
				internalSwitch = new InternalSwitch(telaPrincipal, controllerSwitch);
				controllerCadastroSwitch = new ControllerCadastroSwitch(internalSwitch);
				internalCadastroSwitch = new InternalCadastroSwitch(telaPrincipal, controllerCadastroSwitch);
				controllerCadastroSwitch.setInternalCadastroSwitch(internalCadastroSwitch);
				controllerCadastroSwitch.addListeners();
				telaPrincipal.getDesktopPane().add(internalCadastroSwitch);
				internalCadastroSwitch.setVisible(true);
			}

			if (e.getSource() == telaPrincipal.getMenu().getFuncionarioCadastro()) {
				controllerFuncionario = new ControllerFuncionario(telaPrincipal);
				internalFuncionario = new InternalFuncionario(telaPrincipal, controllerFuncionario);
				telaPrincipal.getDesktopPane().add(internalFuncionario);
				controllerFuncionario.setInternalFuncionario(internalFuncionario);
				controllerFuncionario.setInternalFuncionario(internalFuncionario);
				controllerFuncionario.addListeners();
				internalFuncionario.carregarFuncionarios(fachada.listarTodosFuncionarios());
				internalFuncionario.setVisible(true);

			}
			if (e.getSource() == telaPrincipal.getMenu().getCidadeCadastro()) {
				List<Cidade> cidades = new ArrayList<>();
				cidades = fachada.listarTodosCidades();
				controllerCidade = new ControllerCidade(telaPrincipal);
				internalCidade = new InternalCidade(telaPrincipal, controllerCidade);
				telaPrincipal.getDesktopPane().add(internalCidade);
				internalCidade.carregarCidades(cidades);
				internalCidade.setVisible(true);
				controllerCidade.setInternalCidade(internalCidade);
				controllerCidade.addListeners();

			}

			if (e.getSource() == telaPrincipal.getMenu().getServicoCadastro()) {
				List<Servico> servicos = new ArrayList<>();
				servicos = fachada.listarTodosServico();
				controllerServico = new ControllerServico(telaPrincipal);
				internalServicos = new InternalServicos(telaPrincipal, controllerServico);
				telaPrincipal.getDesktopPane().add(internalServicos);
				internalServicos.carregarServicos(servicos);
				internalServicos.setVisible(true);
				controllerServico.setInternalServicos(internalServicos);
				controllerServico.addListeners();

			}

			if (e.getSource() == telaPrincipal.getMenu().getConcentradorNetwork()) {
				List<Concentrador> concentradores = new ArrayList<>();
				concentradores = fachada.listarTodosConcentrador();
				controllerConcentrador = new ControllerConcentrador(telaPrincipal);
				internalConcentrador = new InternalConcentrador(telaPrincipal, controllerConcentrador);
				telaPrincipal.getDesktopPane().add(internalConcentrador);
				internalConcentrador.carregarConcentrador(concentradores);
				internalConcentrador.setVisible(true);
				controllerConcentrador.setInternalConcentrador(internalConcentrador);
				internalConcentrador.setVisible(true);
				controllerConcentrador.addListeners();

			}

			if (e.getSource() == telaPrincipal.getMenu().getCaixaNetwork()) {
				List<Caixa> caixas = fachada.listarTodosCaixa();
				controllerCaixa = new ControllerCaixa(telaPrincipal);
				internalCaixa = new InternalCaixa(telaPrincipal, controllerCaixa);
				telaPrincipal.getDesktopPane().add(internalCaixa);
				internalCaixa.carregarcaixa(caixas);
				internalCaixa.setVisible(true);
				controllerCaixa.setInternalCaixa(internalCaixa);
				controllerCaixa.addListeners();
			}

		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
	}

	public static void destroyer(Object object) {
		object = null;
		System.gc();
	}

}
