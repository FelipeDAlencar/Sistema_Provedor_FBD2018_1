package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.InternalSwitch;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroSwitch implements Listeners {
	private InternalCadastroSwitch internalCadastroSwitch;
	private Fachada fachada;
	private InternalSwitch internalSwitch;

	public ControllerCadastroSwitch(InternalSwitch internalSwitch) {
		fachada = new Fachada();
		this.internalSwitch = internalSwitch;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroSwitch.getBtnAdicionar()) {
			try {
				Switch switch1 = new Switch(internalCadastroSwitch.getNomeFild().getText().trim(),
						internalCadastroSwitch.getIpFild().getText().trim(), internalCadastroSwitch.getLoginFild().getText().trim(),
						new String(internalCadastroSwitch.getSenhaField().getPassword()),
						Integer.parseInt(internalCadastroSwitch.getNumeroPortasField().getText().trim()));
				String nomeCaixa = (String) internalCadastroSwitch.getCaixaCombo().getSelectedItem();
				String nomeConcentrador = (String) internalCadastroSwitch.getConcentradorCombo().getSelectedItem();

				fachada.salvarOuEditarSwitch(switch1, nomeCaixa, nomeConcentrador);
				internalSwitch.carregarSwitchs(fachada.listarTodosSwitch());
				Menssagens.menssagem("Concentrador inserido com sucesso.", 1);

				internalCadastroSwitch.getNomeFild().setText("");
				internalCadastroSwitch.getIpFild().setText("");
				internalCadastroSwitch.getLoginFild().setText("");
				internalCadastroSwitch.getSenhaField().setText("");
				internalCadastroSwitch.getNumeroPortasField().setText("");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void addListeners() {
		internalCadastroSwitch.getBtnAdicionar().addActionListener(this);

	}

	public InternalCadastroSwitch getInternalCadastroSwitch() {
		return internalCadastroSwitch;
	}

	public void setInternalCadastroSwitch(InternalCadastroSwitch internalCadastroSwitch) {
		this.internalCadastroSwitch = internalCadastroSwitch;
	}

}
