package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;

public class ControllerAtendimentos implements Listeners, ActionListener {
	private InternalAtendimentos internalAtendimentos;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListeners() {
		

	}

	public InternalAtendimentos getInternalAtendimentos() {
		return internalAtendimentos;
	}

	public void setInternalAtendimentos(InternalAtendimentos internalAtendimentos) {
		this.internalAtendimentos = internalAtendimentos;
	}

}
