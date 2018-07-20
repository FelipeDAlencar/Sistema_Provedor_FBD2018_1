package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerServico implements Listeners {
	private InternalServicos internalServicos;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroServico controllerCadastroServico;
	private InternalCadastroServico internalCadastroServico;

	public ControllerServico(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == internalServicos.getBntNovo()) {
			
			try {
				controllerCadastroServico = new ControllerCadastroServico(internalServicos);
				internalCadastroServico = new InternalCadastroServico(telaPrincipal, controllerCadastroServico);
				telaPrincipal.getDesktopPane().add(internalCadastroServico);
				internalCadastroServico.setVisible(true);
				controllerCadastroServico.setInternalCadastroServico(internalCadastroServico);
				controllerCadastroServico.addListeners();
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}

		}

	}

	@Override
	public void addListeners() {
		internalServicos.getBntNovo().addActionListener(this);

	}

	public InternalServicos getInternalServicos() {
		return internalServicos;
	}

	public void setInternalServicos(InternalServicos internalServicos) {
		this.internalServicos = internalServicos;
	}

}
