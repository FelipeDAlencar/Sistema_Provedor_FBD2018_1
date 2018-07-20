package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroSwitch implements Listeners {
	private InternalCadastroSwitch internalSwitch;
	private Fachada fachada;

	public ControllerCadastroSwitch() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalSwitch.getBtnAdicionar()) {
			try {
				Switch switch1 = new Switch(internalSwitch.getNomeFild().getText().trim(),
						internalSwitch.getIpFild().getText().trim(), internalSwitch.getLoginFild().getText().trim(),
						new String(internalSwitch.getSenhaField().getPassword()),
						Integer.parseInt(internalSwitch.getNumeroPortasField().getText().trim()));
				String nomeCaixa = (String) internalSwitch.getCaixaCombo().getSelectedItem();
				String nomeConcentrador = (String) internalSwitch.getConcentradorCombo().getSelectedItem();

				fachada.salvarOuEditarSwitch(switch1, nomeCaixa, nomeConcentrador);
				Menssagens.menssagem("Concentrador inserido com sucesso.", 1);

				internalSwitch.getNomeFild().setText("");
				internalSwitch.getIpFild().setText("");
				internalSwitch.getLoginFild().setText("");
				internalSwitch.getSenhaField().setText("");
				internalSwitch.getNumeroPortasField().setText("");

			} catch (Exception e1) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void addListeners() {
		internalSwitch.getBtnAdicionar().addActionListener(this);

	}

	public InternalCadastroSwitch getInternalCadastroSwitch() {
		return internalSwitch;
	}

	public void setInternalCadastroSwitch(InternalCadastroSwitch internalCadastroSwitch) {
		this.internalSwitch = internalCadastroSwitch;
	}

}
