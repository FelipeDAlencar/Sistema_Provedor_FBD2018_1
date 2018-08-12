package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroAtendimento implements Listeners {
	private InternalCadastroAtendimentos internal;
	private Fachada fachada;
	private InternalAtendimentos internalAtendimentos;

	public ControllerCadastroAtendimento(InternalAtendimentos internalAtendimentos) {
		fachada = new Fachada();
		this.internalAtendimentos = internalAtendimentos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource() == internal.getBtnSalvar()) {
				Atendimento atendimento = new Atendimento(internal.getMotivoField().getText(),
						internal.getProtocoloField().getText(), internal.getDataField().getText());
				
				
				fachada.salvarOuEditarAtendimento(atendimento, internal.getCpfCliente().getText());
				
				internal.getProtocoloField().setText("");
				internal.getCpfCliente().setText("");
				internal.getMotivoField().setText("");
				
				Menssagens.menssagem("Atendimento inserido com sucesso.", 1);
				
				internalAtendimentos.carregarAtendimentos(fachada.listarTodosAtendimento());
			}

		} catch (BusinessException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void addListeners() {
		internal.getBtnSalvar().addActionListener(this);

	}

	public void setInternal(InternalCadastroAtendimentos internal) {
		this.internal = internal;
	}

}
