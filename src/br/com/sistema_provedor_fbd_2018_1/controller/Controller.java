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
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalLocalizarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class Controller implements ActionListener{
	private TelaPrincipal telaPrincipal;
	private Fachada fachada;
	
	public Controller(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;
		
		
		//Botoes desktop
		telaPrincipal.getBntAdicionarCliente().addActionListener(this);
		telaPrincipal.getBntVerCliente().addActionListener(this);
		telaPrincipal.getBntAtendiemntos().addActionListener(this);
		
		//Itens Menu Cadatro
		telaPrincipal.getMenu().getFuncionarioCadastro().addActionListener(this);
		telaPrincipal.getMenu().getServicoCadastro().addActionListener(this);
		telaPrincipal.getMenu().getCidadeCadastro().addActionListener(this);
		
		//itens Menu Cliente
		telaPrincipal.getMenu().getAdicionarCliente().addActionListener(this);
		telaPrincipal.getMenu().getVerCliente().addActionListener(this);
		telaPrincipal.getMenu().getAtendimentosCliente().addActionListener(this);
		
		//itens Menu Network
		telaPrincipal.getMenu().getConcentradorNetwork().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==telaPrincipal.getBntAdicionarCliente()
					|| e.getSource()==telaPrincipal.getMenu().getAdicionarCliente()) {
				telaPrincipal.desativarBotoes();
				InternalAdicionarCliente adicionarCliente;
				adicionarCliente = new InternalAdicionarCliente(telaPrincipal);
				telaPrincipal.getDesktopPane().add(adicionarCliente);
				adicionarCliente.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getBntVerCliente()
					|| e.getSource()==telaPrincipal.getMenu().getVerCliente()) {
				telaPrincipal.desativarBotoes();
				InternalLocalizarCliente localizarCliente;
				localizarCliente = new InternalLocalizarCliente(telaPrincipal);
				telaPrincipal.getDesktopPane().add(localizarCliente);
				localizarCliente.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getBntAtendiemntos()
					|| e.getSource()==telaPrincipal.getMenu().getAtendimentosCliente()) {
				telaPrincipal.desativarBotoes();
				InternalAtendimentos telaAtendimentos;
				telaAtendimentos = new InternalAtendimentos(telaPrincipal);
				telaPrincipal.getDesktopPane().add(telaAtendimentos);
				telaAtendimentos.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getMenu().getFuncionarioCadastro()) {
				telaPrincipal.desativarBotoes();
				InternalFuncionario telaFuncionarios;
				telaFuncionarios = new InternalFuncionario(telaPrincipal);
				telaPrincipal.getDesktopPane().add(telaFuncionarios);
				telaFuncionarios.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getMenu().getServicoCadastro()) {
				telaPrincipal.desativarBotoes();
				InternalServicos telaServicos;
				telaServicos = new InternalServicos(telaPrincipal);
				telaPrincipal.getDesktopPane().add(telaServicos);
				telaServicos.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getMenu().getCidadeCadastro()) {
				List<Cidade> cidades = new ArrayList<>();
				cidades = fachada.listarTodosCidades();
				
				telaPrincipal.desativarBotoes();
				InternalCidade telaCidades;
				telaCidades = new InternalCidade(telaPrincipal);
				telaPrincipal.getDesktopPane().add(telaCidades);
				telaCidades.carregarCidades(cidades);
				telaCidades.setVisible(true);
			}
			
			if(e.getSource()==telaPrincipal.getMenu().getConcentradorNetwork()) {
				telaPrincipal.desativarBotoes();
				InternalConcentrador telaConcentrador;
				telaConcentrador = new InternalConcentrador(telaPrincipal);
				telaPrincipal.getDesktopPane().add(telaConcentrador);
				telaConcentrador.setVisible(true);
			}
			
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
	}


}
