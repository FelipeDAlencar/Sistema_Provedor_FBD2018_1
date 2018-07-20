package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroAtendimentos;

public class ControllerCadastroAtendimento implements Listeners{
	private InternalCadastroAtendimentos internalCadastroAtendimentos;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public InternalCadastroAtendimentos getInternalCadastroAtendimentos() {
		return internalCadastroAtendimentos;
	}

	public void setInternalCadastroAtendimentos(InternalCadastroAtendimentos internalCadastroAtendimentos) {
		this.internalCadastroAtendimentos = internalCadastroAtendimentos;
	}
	
	

}
