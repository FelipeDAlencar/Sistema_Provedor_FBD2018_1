package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroCidade implements Listeners {

	private InternalCadastroCidade internalCadastroCidade;
	private Fachada fachada;

	public ControllerCadastroCidade() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroCidade.getBtnAdd()) {
			Cidade cidade = new Cidade(internalCadastroCidade.getNomeField().getText(),
					internalCadastroCidade.getEstadoField().getText().toUpperCase(),
					internalCadastroCidade.getCepField().getText());
			Menssagens.menssagem("Cidade salva com sucesso!", 1);

			internalCadastroCidade.getNomeField().setText("");
			internalCadastroCidade.getEstadoField().setText("");
			internalCadastroCidade.getCepField().setText("");
			try {
				fachada.salvarOuEditarCidade(cidade);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		}
	}

	@Override
	public void addListeners() {
		internalCadastroCidade.getBtnAdd().addActionListener(this);

	}

	public InternalCadastroCidade getInternalCadastroCidade() {
		return internalCadastroCidade;
	}

	public void setInternalCadastroCidade(InternalCadastroCidade internalCadastroCidade) {
		this.internalCadastroCidade = internalCadastroCidade;
	}

}
