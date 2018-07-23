package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarConcentrador implements Listeners {
	private InternalEditarConcentrador internalEditarConcentrador;
	private Fachada fachada;
	private Concentrador concentrador;

	public ControllerEditarConcentrador(Concentrador concentrador) {
		this.concentrador = concentrador;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource()==internalEditarConcentrador.getBtnAdicionar()) {
				Concentrador concentrador = new Concentrador(
						this.concentrador.getId(),
						internalEditarConcentrador.getNomeField().getText().trim(),
						internalEditarConcentrador.getIpField().getText().trim(),
						internalEditarConcentrador.getLoginField().getText().trim(),
						new String(internalEditarConcentrador.getSenhaField().getPassword()));
				fachada.salvarOuEditarConcentrador(concentrador, internalEditarConcentrador.getCidadesCombo().getSelectedItem().toString());
				Menssagens.menssagem("Concentrador editado com sucesso", 1);
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}

	}

	public void preencherCampos() {
		try {
			Cidade cidade = fachada.buscarCidadePorId(concentrador.getCidade_id());
			internalEditarConcentrador.getSenhaField().setText(concentrador.getSenha());
			internalEditarConcentrador.getIpField().setText(concentrador.getIp());
			internalEditarConcentrador.getLoginField().setText(concentrador.getLogin());
			internalEditarConcentrador.getNomeField().setText(concentrador.getNome());
			internalEditarConcentrador.getCidadesCombo().setSelectedItem(cidade.getNome());

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addListeners() {
		internalEditarConcentrador.getBtnAdicionar().addActionListener(this);
	}

	public InternalEditarConcentrador getInternalEditarConcentrador() {
		return internalEditarConcentrador;
	}

	public void setInternalEditarConcentrador(InternalEditarConcentrador internalEditarConcentrador) {
		this.internalEditarConcentrador = internalEditarConcentrador;
	}




}
