package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarCaixa implements Listeners {
	private InternalEditarCaixa internalEditarCaixa;
	private Caixa caixa;
	private Fachada fachada;


	public ControllerEditarCaixa(Caixa caixa) {
		this.caixa = caixa;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==internalEditarCaixa.getBtnCadastrar()){
				Caixa caixa = new Caixa(
						this.caixa.getId(),
						internalEditarCaixa.getNomeField().getText().trim(),
						internalEditarCaixa.getLatitudeField().getText().trim(),
						internalEditarCaixa.getLongitudeField().getText().trim());


				fachada.salvarOuEditarCaixa(caixa, internalEditarCaixa.getCidadeCombo().getSelectedItem().toString());
				Menssagens.menssagem("Caixa editada com sucesso!", 1);
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}

	}

	public void preencherCampos() {
		try {
			Cidade cidade = fachada.buscarCidadePorId(caixa.getCidade_id());

			internalEditarCaixa.getNomeField().setText(caixa.getNome());
			internalEditarCaixa.getLatitudeField().setText(caixa.getLatitude());
			internalEditarCaixa.getLongitudeField().setText(caixa.getLongitude());
			internalEditarCaixa.getCidadeCombo().setSelectedItem(cidade.getNome());


		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addListeners() {
		internalEditarCaixa.getBtnCadastrar().addActionListener(this);
	}

	public InternalEditarCaixa getInternalEditarCaixa() {
		return internalEditarCaixa;
	}

	public void setInternalEditarCaixa(InternalEditarCaixa internalEditarCaixa) {
		this.internalEditarCaixa = internalEditarCaixa;
	}






}
