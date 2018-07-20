package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerAtendimentos implements Listeners{
	private TelaPrincipal telaPrincipal;
	private InternalAtendimentos internalAtendimentos;
	private ControllerCadastroAtendimento controllerCadastroAtendimento;
	private InternalCadastroAtendimentos internalCadastroAtendimentos;

	public ControllerAtendimentos(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalAtendimentos.getBtnNovo()){
				controllerCadastroAtendimento = new ControllerCadastroAtendimento();
				internalCadastroAtendimentos = new InternalCadastroAtendimentos(telaPrincipal, controllerCadastroAtendimento);
				telaPrincipal.getDesktopPane().add(internalCadastroAtendimentos);
				controllerCadastroAtendimento.setInternalCadastroAtendimentos(internalCadastroAtendimentos);
				controllerCadastroAtendimento.addListeners();
				internalCadastroAtendimentos.setVisible(true);

			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void addListeners() {
		internalAtendimentos.getBtnNovo().addActionListener(this);
	}
	public InternalAtendimentos getInternalAtendimentos() {
		return internalAtendimentos;
	}
	public void setInternalAtendimentos(InternalAtendimentos internalAtendimentos) {
		this.internalAtendimentos = internalAtendimentos;
	}
	

}
