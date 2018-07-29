package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerVerCliente implements Listeners {
	private InternalVerCliente internalVerCliente;
	private Fachada fachada;
	private Cliente cliente;

	public ControllerVerCliente(Cliente cliente) {
		fachada = new Fachada();
		this.cliente = cliente;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void carregarDados() {
			internalVerCliente.getNomeField().setText(cliente.getNome());
	}

	@Override
	public void addListeners() {
	}

	public InternalVerCliente getInternalVerCliente() {
		return internalVerCliente;
	}

	public void setInternalVerCliente(InternalVerCliente internalVerCliente) {
		this.internalVerCliente = internalVerCliente;
	}

	

}
