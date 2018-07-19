package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCidade implements Listeners {
	private InternalCidade internalCidade;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroCidade controllerCadastroCidade;
	private InternalCadastroCidade internalCadastroCidade;

	public ControllerCidade(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCidade.getBntNovo()) {
			try {			
				controllerCadastroCidade =  new ControllerCadastroCidade();
				internalCadastroCidade = new InternalCadastroCidade(telaPrincipal, controllerCadastroCidade);
				telaPrincipal.getDesktopPane().add(internalCadastroCidade);
				controllerCadastroCidade.setInternalCadastroCidade(internalCadastroCidade);
				internalCadastroCidade.setVisible(true);
				controllerCadastroCidade.setInternalCadastroCidade(internalCadastroCidade);
				controllerCadastroCidade.addListeners();
				
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}

	@Override
	public void addListeners() {
		internalCidade.getBntNovo().addActionListener(this);

	}

	public InternalCidade getInternalCidade() {
		return internalCidade;
	}

	public void setInternalCidade(InternalCidade internalCidade) {
		this.internalCidade = internalCidade;
	}

}
