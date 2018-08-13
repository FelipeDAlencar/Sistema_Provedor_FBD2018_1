package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumAtendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroAtendimento implements Listeners {
	private Fachada fachada;
	private Cliente cliente;
	private InternalVerCliente internalVerCliente;
	private InternalCadastroAtendimentos internalCadastroAtendimentos;

	public ControllerCadastroAtendimento(Cliente cliente, InternalVerCliente internalVerCliente) {
		fachada = new Fachada();
		this.cliente = cliente;
		this.internalVerCliente = internalVerCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalCadastroAtendimentos.getBtnSalvar()) {
				String descricao = internalCadastroAtendimentos.getServicosCombo().getSelectedItem().toString();
				int servico_id = fachada.buscarservicoclientesPorDescricao(descricao);
				descricao = cliente.getId()+" Servico: "+descricao;
				
				Atendimento atendimento = new Atendimento(
						cliente.getId(),
						internalCadastroAtendimentos.getMotivoField().getText().trim(),
						internalCadastroAtendimentos.getDataField().getText().trim(),
						enumAtendimento.getEnum("aberto"),
						servico_id,
						descricao);
				fachada.salvarOuEditarAtendimento(atendimento);
				List<Atendimento> atendimentos =fachada.buscarAtendimentoPorCliente(cliente.getId());
				internalVerCliente.getPanelAtendimento().carregarAtendimento(atendimentos);
				Menssagens.menssagem("Atendimento cadastrado com sucesso!", 1);
			}
			
		} catch (BusinessException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void addListeners() {
		internalCadastroAtendimentos.getBtnSalvar().addActionListener(this);

	}

	public void setInternal(InternalCadastroAtendimentos internal) {
		this.internalCadastroAtendimentos = internal;
	}

}
