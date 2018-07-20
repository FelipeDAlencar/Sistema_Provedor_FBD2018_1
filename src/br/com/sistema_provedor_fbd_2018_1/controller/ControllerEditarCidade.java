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

public class ControllerEditarCidade implements Listeners, ItemListener {
	private InternalEditarCidade internalEditarCidade;
	private Fachada fachada;

	public ControllerEditarCidade() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalEditarCidade.getBtnAdd()) {

			try {
				String id = (String) internalEditarCidade.getComboIDCidade().getSelectedItem();
				Cidade cidade = new Cidade(Integer.parseInt(id), internalEditarCidade.getNomeField().getText(),
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

	@Override
	public void itemStateChanged(ItemEvent e) {

		String id = (String) internalEditarCidade.getComboIDCidade().getSelectedItem();

		try {
			for (Cidade cidade : fachada.listarTodosCidades()) {
				if (cidade.getId() == Integer.parseInt(id)) {
					internalEditarCidade.getNomeField().setText(cidade.getNome());
					internalEditarCidade.getEstadoField().setText(cidade.getEstado());
					internalEditarCidade.getCepField().setText(cidade.getCep());

				}
			}
		} catch (BusinessException e1) {
			e1.getMessage();

		}
	}

	@Override
	public void addListeners() {
		internalEditarCidade.getBtnAdd().addActionListener(this);
		internalEditarCidade.getComboIDCidade().addItemListener(this);

	}

	public InternalEditarCidade getInternalEditarCidade() {
		return internalEditarCidade;
	}

	public void setInternalEditarCidade(InternalEditarCidade internalEditarCidade) {
		this.internalEditarCidade = internalEditarCidade;
	}

}
