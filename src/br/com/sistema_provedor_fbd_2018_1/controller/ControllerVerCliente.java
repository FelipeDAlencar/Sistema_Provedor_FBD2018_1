package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerVerCliente implements Listeners {
	private InternalVerCliente internalVerCliente;
	private TelaPrincipal telaPrincipal;
	private ControllerAdicionarServico controllerAdicionarServico;
	private InternalAdicionarServico internalAdicionarServico;
	private Fachada fachada;
	private Cliente cliente;

	public ControllerVerCliente( TelaPrincipal telaPrincipal, Cliente cliente) {
		fachada = new Fachada();
		this.cliente = cliente;
		this.telaPrincipal = telaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internalVerCliente.getPanelServico().getBntAdicionar()) {
				controllerAdicionarServico = new ControllerAdicionarServico(internalVerCliente, cliente);
				internalAdicionarServico = new InternalAdicionarServico(telaPrincipal, controllerAdicionarServico);
				telaPrincipal.getDesktopPane().add(internalAdicionarServico);
				internalAdicionarServico.setVisible(true);
				controllerAdicionarServico.setInternalAdicionarServico(internalAdicionarServico);
				controllerAdicionarServico.addListeners();
			}

		} catch (BusinessException e1) {
			e1.printStackTrace();
		}


	}

	public void carregarDados() {
		internalVerCliente.getNomeField().setText(cliente.getNome());
	}

	@Override
	public void addListeners() {
		internalVerCliente.getPanelServico().getBntAdicionar().addActionListener(this);;
	}

	public InternalVerCliente getInternalVerCliente() {
		return internalVerCliente;
	}

	public void setInternalVerCliente(InternalVerCliente internalVerCliente) {
		this.internalVerCliente = internalVerCliente;
	}



}
