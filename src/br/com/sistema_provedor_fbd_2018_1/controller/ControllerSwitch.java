package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;

public class ControllerSwitch implements Listeners {
	private InternalSwitch internalSwitch;
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public InternalSwitch getInternalSwitch() {
		return internalSwitch;
	}

	public void setInternalSwitch(InternalSwitch internalSwitch) {
		this.internalSwitch = internalSwitch;
	}
	

}