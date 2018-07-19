package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCaixa implements Listeners {
	private InternalCaixa internalCaixa;
	private TelaPrincipal telaPrincipal;
	private InternalCadastroCaixa internalCadastroCaixa;
	private ControllerCadastroCaixa controllerCadastroCaixa;
	
	public ControllerCaixa(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == internalCaixa.getBntNovo()) {
			
			try {
				controllerCadastroCaixa = new ControllerCadastroCaixa();
				internalCadastroCaixa = new InternalCadastroCaixa(telaPrincipal, controllerCadastroCaixa);
				telaPrincipal.getDesktopPane().add(internalCadastroCaixa);
				internalCadastroCaixa.setVisible(true);
				controllerCadastroCaixa.setInternalCadastroCaixa(internalCadastroCaixa);
				System.out.println(internalCadastroCaixa);
				controllerCadastroCaixa.addListeners();
				
				
				
				
			} catch (BusinessException e1) {
				
				e1.printStackTrace();
			}
			
			
		}
		
		
	}

	@Override
	public void addListeners() {
		internalCaixa.getBntNovo().addActionListener(this);
		
	}

	public InternalCaixa getInternalCaixa() {
		return internalCaixa;
	}

	public void setInternalCaixa(InternalCaixa internalCaixa) {
		this.internalCaixa = internalCaixa;
	}
	

}
