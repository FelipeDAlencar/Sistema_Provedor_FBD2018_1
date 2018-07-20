package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;

public class ControllerAtendimentos implements Listeners{
	private InternalAtendimentos internalAtendimentos;	

	public ControllerAtendimentos() {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

	@Override
	public void addListeners() {
		internalAtendimentos.getBtnAbrir().addActionListener(this);
	}
	public InternalAtendimentos getInternalAtendimentos() {
		return internalAtendimentos;
	}
	public void setInternalAtendimentos(InternalAtendimentos internalAtendimentos) {
		this.internalAtendimentos = internalAtendimentos;
	}
	

}
