package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;

public class ControllerServico implements Listeners {
	private InternalServicos internalServicos;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public InternalServicos getInternalServicos() {
		return internalServicos;
	}

	public void setInternalServicos(InternalServicos internalServicos) {
		this.internalServicos = internalServicos;
	}
	

}
