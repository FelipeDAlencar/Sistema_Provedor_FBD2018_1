package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;

public class ControllerConcentrador implements Listeners {
	private InternalConcentrador internalConcentrador;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public InternalConcentrador getInternalConcentrador() {
		return internalConcentrador;
	}

	public void setInternalConcentrador(InternalConcentrador internalConcentrador) {
		this.internalConcentrador = internalConcentrador;
	}
	

}
