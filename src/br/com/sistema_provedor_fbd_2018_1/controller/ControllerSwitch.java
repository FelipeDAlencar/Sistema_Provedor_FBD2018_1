package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerSwitch implements Listeners {
	private InternalSwitch internalSwitch;
	private Fachada fachada;
	private ControllerCadastroSwitch controllerCadastroSwitch;
	private InternalCadastroSwitch internalCadastroSwitch;
	private TelaPrincipal telaPrincipal;
	private ControllerEditarSwitch controllerEditarSwitch;
	private InternalEditarSwitch internalEditarSwitch;

	public ControllerSwitch(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalSwitch.getBtnNovo()) {


				controllerCadastroSwitch = new ControllerCadastroSwitch();
				internalCadastroSwitch = new InternalCadastroSwitch(telaPrincipal, controllerCadastroSwitch);
				telaPrincipal.getDesktopPane().add(internalCadastroSwitch);
				internalCadastroSwitch.setVisible(true);
				controllerCadastroSwitch.setInternalCadastroSwitch(internalCadastroSwitch);
				controllerCadastroSwitch.addListeners();

			}
			
			if (e.getSource()==internalSwitch.getBtnEditar()) {
				int linha = internalSwitch.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalSwitch.getModelTable().getValueAt(linha, 0).toString());
				
				Switch sw = fachada.buscarSwitchPorId(id);
				
				controllerEditarSwitch = new ControllerEditarSwitch(sw);
				internalEditarSwitch = new InternalEditarSwitch(telaPrincipal, controllerEditarSwitch);
				controllerEditarSwitch.setInternalEditarSwitch(internalEditarSwitch);
				controllerEditarSwitch.addListeners();
				controllerEditarSwitch.preencherCampos();
				telaPrincipal.getDesktopPane().add(internalEditarSwitch);
				internalEditarSwitch.setVisible(true);
			}

		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
