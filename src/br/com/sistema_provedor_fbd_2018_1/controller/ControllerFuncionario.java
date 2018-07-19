package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerFuncionario implements Listeners {
	private InternalFuncionario internalFuncionario;
	private InternalCadastroFuncionario internalCadastroFuncionario;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroFuncionario controllerCadastroFuncionario;

	public ControllerFuncionario(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalFuncionario.getBntNovo()) {
			try {
				controllerCadastroFuncionario = new ControllerCadastroFuncionario();
				internalCadastroFuncionario = new InternalCadastroFuncionario(telaPrincipal, controllerCadastroFuncionario);
				telaPrincipal.getDesktopPane().add(internalCadastroFuncionario);
				internalCadastroFuncionario.setVisible(true);
				controllerCadastroFuncionario.setInternalCadastroFuncionario(internalCadastroFuncionario);
				controllerCadastroFuncionario.addListeners();
				
				
				
				
			} catch (BusinessException e1) {
				e1.printStackTrace();
			}
		}

	}

	public InternalFuncionario getInternalFuncionario() {
		return internalFuncionario;
	}

	public void setInternalFuncionario(InternalFuncionario internalFuncionario) {
		this.internalFuncionario = internalFuncionario;

	}

	public InternalCadastroFuncionario getInternalCadastroFuncionario() {
		return internalCadastroFuncionario;
	}

	public TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	@Override
	public void addListeners() {
		internalFuncionario.getBntNovo().addActionListener(this);

	}

}
