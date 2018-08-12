package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroCaixa implements Listeners {
	private InternalCadastroCaixa internalCadastroCaixa;
	private Fachada fachada;
	private InternalCaixa internalCaixa;

	public ControllerCadastroCaixa(InternalCaixa internalCaixa) {
		fachada = new Fachada();
		this.internalCaixa = internalCaixa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalCadastroCaixa.getBtnCadastrar()) {


				Caixa caixa = new Caixa(internalCadastroCaixa.getNomeField().getText(),
						internalCadastroCaixa.getLatitudeField().getText(),
						internalCadastroCaixa.getLongitudeField().getText());
				fachada.salvarOuEditarCaixa(caixa, internalCadastroCaixa.getCidadeCombo().getSelectedItem().toString());
				internalCaixa.carregarcaixa(fachada.listarTodosCaixa());
				Menssagens.menssagem("Caixa cadastrada com sucesso.", 1);
				internalCadastroCaixa.getNomeField().setText("");
				internalCadastroCaixa.getLatitudeField().setText("");
				internalCadastroCaixa.getLongitudeField().setText("");
				internalCadastroCaixa.getCidadeCombo().setSelectedIndex(0);


			}
			
		} catch (BusinessException e1) {
			e1.printStackTrace();
			e1.getMessage();
		}

	}

	@Override
	public void addListeners() {

		internalCadastroCaixa.getBtnCadastrar().addActionListener(this);

	}

	public InternalCadastroCaixa getInternalCadastroCaixa() {
		return internalCadastroCaixa;
	}

	public void setInternalCadastroCaixa(InternalCadastroCaixa internalCadastroCaixa) {
		this.internalCadastroCaixa = internalCadastroCaixa;
	}

}
