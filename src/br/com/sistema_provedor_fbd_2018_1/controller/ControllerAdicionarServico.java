package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;

public class ControllerAdicionarServico implements Listeners, ItemListener {
	private InternalAdicionarServico internalAdicionarServico;

	public ControllerAdicionarServico() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void addListeners() {

	}

	public void setInternalAdicionarServico(InternalAdicionarServico internalAdicionarServico) {
		this.internalAdicionarServico = internalAdicionarServico;
		
	}

}
