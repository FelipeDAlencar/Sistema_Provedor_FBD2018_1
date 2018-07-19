package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalLocalizarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class Controller implements ActionListener {
	private TelaPrincipal telaPrincipal;
	private Fachada fachada;
	private InternalAdicionarCliente internalAdicionarCliente;
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

	public Controller(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;

		// Botoes desktop
		telaPrincipal.getBntAdicionarCliente().addActionListener(this);
		telaPrincipal.getBntVerCliente().addActionListener(this);
		telaPrincipal.getBntAtendiemntos().addActionListener(this);
		telaPrincipal.getBntAdicionarSwitch().addActionListener(this);

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
		// telaPrincipal.getBntAdicionarSwitch().addActionListener(this);
		telaPrincipal.getMenu().getCaixaNetwork().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			telaPrincipal.desativarBotoes();
			if (e.getSource() == telaPrincipal.getBntAdicionarCliente()
					|| e.getSource() == telaPrincipal.getMenu().getAdicionarCliente()) {
				controllerCadastroCliente = new ControllerCliente();
				internalAdicionarCliente = new InternalAdicionarCliente(telaPrincipal, controllerCadastroCliente);
				telaPrincipal.getDesktopPane().add(internalAdicionarCliente);
				internalAdicionarCliente.setVisible(true);
				controllerCadastroCliente.setAdicionarCliente(internalAdicionarCliente);
				controllerCadastroCliente.addListenners();

			}

			if (e.getSource() == telaPrincipal.getBntVerCliente()
					|| e.getSource() == telaPrincipal.getMenu().getVerCliente()) {
				controllerVisualizar = new ControllerVisualizar();
				internalLocalizarCliente = new InternalLocalizarCliente(telaPrincipal, controllerVisualizar);
				telaPrincipal.getDesktopPane().add(internalLocalizarCliente);
				internalLocalizarCliente.setVisible(true);
				controllerVisualizar.setInternalLocalizarCliente(internalLocalizarCliente);
				controllerVisualizar.addListeners();
			}
			if (e.getSource() == telaPrincipal.getBntAtendiemntos()
					|| e.getSource() == telaPrincipal.getMenu().getAtendimentosCliente()) {
				controllerAtendimentos = new ControllerAtendimentos();
				internalAtendimentos = new InternalAtendimentos(telaPrincipal, controllerAtendimentos);
				telaPrincipal.getDesktopPane().add(internalAtendimentos);
				internalAtendimentos.setVisible(true);
				controllerAtendimentos.setInternalAtendimentos(internalAtendimentos);
				controllerAtendimentos.addListeners();
			}

			if (e.getSource() == telaPrincipal.getBntAdicionarSwitch()
					|| e.getSource() == telaPrincipal.getMenu().getSwitchNetwork()) {
				controllerSwitch = new ControllerSwitch();
				internalSwitch = new InternalSwitch(telaPrincipal, controllerSwitch);
				telaPrincipal.getDesktopPane().add(internalSwitch);
				internalSwitch.setVisible(true);
				controllerSwitch.setInternalSwitch(internalSwitch);
				controllerSwitch.addListeners();
			}

			if (e.getSource() == telaPrincipal.getMenu().getFuncionarioCadastro()) {
				controllerFuncionario = new ControllerFuncionario(telaPrincipal);
				internalFuncionario = new InternalFuncionario(telaPrincipal, controllerFuncionario);
				telaPrincipal.getDesktopPane().add(internalFuncionario);
				controllerFuncionario.setInternalFuncionario(internalFuncionario);
				internalFuncionario.setVisible(true);
				controllerFuncionario.setInternalFuncionario(internalFuncionario);
				controllerFuncionario.addListeners();

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
				controllerServico = new ControllerServico(telaPrincipal);
				internalServicos = new InternalServicos(telaPrincipal, controllerServico);
				telaPrincipal.getDesktopPane().add(internalServicos);
				internalServicos.setVisible(true);
				controllerServico.setInternalServicos(internalServicos);
				controllerServico.addListeners();

			}

			if (e.getSource() == telaPrincipal.getMenu().getConcentradorNetwork()) {
				controllerConcentrador = new ControllerConcentrador();
				internalConcentrador = new InternalConcentrador(telaPrincipal, controllerConcentrador);
				telaPrincipal.getDesktopPane().add(internalConcentrador);
				internalConcentrador.setVisible(true);
				controllerConcentrador.setInternalConcentrador(internalConcentrador);
				internalConcentrador.setVisible(true);
				controllerConcentrador.addListeners();

			}

			if (e.getSource() == telaPrincipal.getMenu().getCaixaNetwork()) {
				controllerCaixa = new ControllerCaixa(telaPrincipal);
				internalCaixa = new InternalCaixa(telaPrincipal, controllerCaixa);
				telaPrincipal.getDesktopPane().add(internalCaixa);
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
