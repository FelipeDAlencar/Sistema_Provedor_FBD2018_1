package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarCidade implements Listeners {
	private InternalEditarCidade internalEditarCidade;
	private Fachada fachada;
	private Cidade cidade;

	public ControllerEditarCidade(Cidade cidade) {
		fachada = new Fachada();
		this.cidade = cidade;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalEditarCidade.getBtnAdd()) {
			
			try {
				Cidade cidade = new Cidade(this.cidade.getId(), internalEditarCidade.getNomeField().getText(),
						internalEditarCidade.getEstadoField().getText(), internalEditarCidade.getCepField().getText());
				fachada.salvarOuEditarCidade(cidade);
				Menssagens.menssagem("Edição realizada com sucesso.", 1);

				internalEditarCidade.getNomeField().setText("");
				internalEditarCidade.getEstadoField().setText("");
				internalEditarCidade.getCepField().setText("");
			} catch (Exception e1) {
				e1.getMessage();
			}
		}

	}

	public void carregarDados() {
			internalEditarCidade.getNomeField().setText(cidade.getNome());
			internalEditarCidade.getEstadoField().setText(cidade.getEstado());
			internalEditarCidade.getCepField().setText(cidade.getCep());
	}

	@Override
	public void addListeners() {
		internalEditarCidade.getBtnAdd().addActionListener(this);
	}

	public InternalEditarCidade getInternalEditarCidade() {
		return internalEditarCidade;
	}

	public void setInternalEditarCidade(InternalEditarCidade internalEditarCidade) {
		this.internalEditarCidade = internalEditarCidade;
		
	}

}
