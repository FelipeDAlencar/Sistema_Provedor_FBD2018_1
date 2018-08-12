package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarCidade implements Listeners {
	private InternalEditarCidade internalEditarCidade;
	private Fachada fachada;
	private Cidade cidade;
	private InternalCidade internalCidade;

	public ControllerEditarCidade(InternalCidade internalCidade, Cidade cidade) {
		fachada = new Fachada();
		this.cidade = cidade;
		this.internalCidade = internalCidade;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalEditarCidade.getBtnAdd()) {
			
			try {
				Cidade cidade = new Cidade(this.cidade.getId(), internalEditarCidade.getNomeField().getText(),
						internalEditarCidade.getEstadoField().getText().toUpperCase(), internalEditarCidade.getCepField().getText(), true);
				fachada.salvarOuEditarCidade(cidade);
				Menssagens.menssagem("Edição realizada com sucesso.", 1);

				internalCidade.carregarCidades(fachada.listarTodosCidades());
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
