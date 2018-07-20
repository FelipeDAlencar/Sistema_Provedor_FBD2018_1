package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCidade implements Listeners {
	private InternalCidade internalCidade;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroCidade controllerCadastroCidade;
	private InternalCadastroCidade internalCadastroCidade;
	private ControllerEditarCidade controllerEditarCidade;
	private InternalEditarCidade internalEditarCidade;

	public ControllerCidade(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCidade.getBntNovo()) {
			try {
				controllerCadastroCidade = new ControllerCadastroCidade();
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
		if (e.getSource() == internalCidade.getBntEditar()) {

			try {
				controllerEditarCidade = new ControllerEditarCidade();
				internalEditarCidade = new InternalEditarCidade(telaPrincipal, controllerEditarCidade);
				telaPrincipal.getDesktopPane().add(internalEditarCidade);
				internalEditarCidade.setVisible(true);
				controllerEditarCidade.setInternalEditarCidade(internalEditarCidade);
				controllerEditarCidade.addListeners();

			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}

		}

	}

	@Override
	public void addListeners() {
		internalCidade.getBntNovo().addActionListener(this);
		internalCidade.getBntEditar().addActionListener(this);
	}

	public InternalCidade getInternalCidade() {
		return internalCidade;
	}

	public void setInternalCidade(InternalCidade internalCidade) {
		this.internalCidade = internalCidade;
	}

}
