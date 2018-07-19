package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;

public class ControllerCaixa implements Listeners {
	private InternalCaixa internalCaixa;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public InternalCaixa getInternalCaixa() {
		return internalCaixa;
	}

	public void setInternalCaixa(InternalCaixa internalCaixa) {
		this.internalCaixa = internalCaixa;
	}
	

}
