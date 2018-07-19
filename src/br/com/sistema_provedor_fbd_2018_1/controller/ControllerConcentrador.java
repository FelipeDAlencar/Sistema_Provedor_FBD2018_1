package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerConcentrador implements Listeners {
	private TelaPrincipal telaPrincipal;
	private InternalConcentrador internalConcentrador;
	private InternalCadastroConcentrador internalCadastroConcentrador;
	private ControllerCadastroConcentrador controllerCadastroConcentrador;
	
	public ControllerConcentrador(TelaPrincipal telaPrincipal) {
		this.telaPrincipal= telaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
		if (arg0.getSource() == internalConcentrador.getBtnNovo()) {
			controllerCadastroConcentrador = new ControllerCadastroConcentrador();
			internalCadastroConcentrador = new InternalCadastroConcentrador(telaPrincipal, controllerCadastroConcentrador);
			telaPrincipal.getDesktopPane().add(internalCadastroConcentrador);
			internalCadastroConcentrador.setVisible(true);
			controllerCadastroConcentrador.setInternalCadastroConcentrador(internalCadastroConcentrador);
			controllerCadastroConcentrador.addListeners();			
		}
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addListeners() {
		internalConcentrador.getBtnNovo().addActionListener(this);
		internalConcentrador.getBtnEditar().addActionListener(this);
		internalConcentrador.getBtnRemover().addActionListener(this);
		
	}

	public InternalConcentrador getInternalConcentrador() {
		return internalConcentrador;
	}

	public void setInternalConcentrador(InternalConcentrador internalConcentrador) {
		this.internalConcentrador = internalConcentrador;
	}
	

}
