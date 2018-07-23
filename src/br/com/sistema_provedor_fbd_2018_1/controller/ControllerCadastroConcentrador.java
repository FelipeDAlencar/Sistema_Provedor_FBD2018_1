package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroConcentrador implements Listeners {
	private InternalCadastroConcentrador internalCadastroConcentrador;
	private Fachada fachada;

	public ControllerCadastroConcentrador() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroConcentrador.getBtnAdicionar()) {
			try {
				Concentrador concentrador = new Concentrador(internalCadastroConcentrador.getNomeField().getText(),
						internalCadastroConcentrador.getIpField().getText(),
						internalCadastroConcentrador.getLoginField().getText(),
						new String(internalCadastroConcentrador.getSenhaField().getPassword()));
				fachada.salvarOuEditarConcentrador(concentrador, internalCadastroConcentrador.getCidadesCombo().getSelectedItem().toString());
				Menssagens.menssagem("Concentrador inserido com sucesso.", 1);
				
				internalCadastroConcentrador.getNomeField().setText("");
				internalCadastroConcentrador.getIpField().setText("");
				internalCadastroConcentrador.getLoginField().setText("");
				internalCadastroConcentrador.getSenhaField().setText("");
				internalCadastroConcentrador.getCidadesCombo().setSelectedIndex(0);
				

			} catch (Exception e1) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void addListeners() {
		internalCadastroConcentrador.getBtnAdicionar().addActionListener(this);

	}

	public InternalCadastroConcentrador getInternalCadastroConcentrador() {
		return internalCadastroConcentrador;
	}

	public void setInternalCadastroConcentrador(InternalCadastroConcentrador internalCadastroConcentrador) {
		this.internalCadastroConcentrador = internalCadastroConcentrador;
	}

}
