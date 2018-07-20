package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerSwitch implements Listeners {
	private InternalSwitch internalSwitch;
	private ControllerCadastroSwitch ControllerCadastroSwitch;
	private InternalCadastroSwitch internalCadastroSwitch;
	private TelaPrincipal telaPrincipal;

	public ControllerSwitch(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalSwitch.getBtnNovo()) {
			try {

				ControllerCadastroSwitch = new ControllerCadastroSwitch();
				internalCadastroSwitch = new InternalCadastroSwitch(telaPrincipal, ControllerCadastroSwitch);
				telaPrincipal.getDesktopPane().add(internalCadastroSwitch);
				internalCadastroSwitch.setVisible(true);
				ControllerCadastroSwitch.setInternalCadastroSwitch(internalCadastroSwitch);
				ControllerCadastroSwitch.addListeners();

			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void addListeners() {
		internalSwitch.getBtnNovo().addActionListener(this);
		internalSwitch.getBtnEditar().addActionListener(this);
		internalSwitch.getBtnRemover().addActionListener(this);

	}

	public InternalSwitch getInternalSwitch() {
		return internalSwitch;
	}

	public void setInternalSwitch(InternalSwitch internalSwitch) {
		this.internalSwitch = internalSwitch;
	}

}
