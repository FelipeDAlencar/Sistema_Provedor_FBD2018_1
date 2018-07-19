package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;

public class ControllerCadastroCidade implements Listeners {
	
	private InternalCadastroCidade internalCadastroCidade;
	private Fachada fachada;
	
	
	public ControllerCadastroCidade() {
		fachada = new Fachada();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == internalCadastroCidade.getBtnAdd()) {
			JOptionPane.showMessageDialog(null, "AQUI", "", 0);
		}
	}

	@Override
	public void addListeners() {
		internalCadastroCidade.getBtnAdd().addActionListener(this);
		
	}

	public InternalCadastroCidade getInternalCadastroCidade() {
		return internalCadastroCidade;
	}

	public void setInternalCadastroCidade(InternalCadastroCidade internalCadastroCidade) {
		this.internalCadastroCidade = internalCadastroCidade;
	}
	
	

}
