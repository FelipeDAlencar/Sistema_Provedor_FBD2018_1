package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContrato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroContrato implements Listeners {
	private IFachada fachada;
	private InternalCadastroContrato internal;
	private InternalVerCliente internalVerCliente;
	private Cliente cliente;

	public ControllerCadastroContrato(InternalVerCliente internalVerCliente, Cliente cliente) {
		this.cliente = cliente;
		this.internalVerCliente = internalVerCliente;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internal.getBtnSalvar()) {
				int servico_id = fachada.buscarservicoclientesPorDescricao(
						internal.getServicoCombo().getSelectedItem().toString());
				Contrato contrato = new Contrato(
						cliente.getId(),
						Double.parseDouble(internal.getValorInstalacaoField().getText()),
						Double.parseDouble(internal.getValorMensalField().getText()),
						servico_id,
						Integer.parseInt(internal.getNumeroParcelasField().getText()));

				Parcela parcela = new Parcela(contrato.getValor_mensal(), internal.getDataVencimentoField().getText(),
						true);

				fachada.salvarOuEditarContrato(contrato, parcela);
				
				internalVerCliente.getFinanceiroPanel()
						.carregarTabelas(fachada.buscarContratoPorClienteID(cliente.getId()));
				internal.getValorInstalacaoField().setText("");
				internal.getValorMensalField().setText("");
				internal.getDataVencimentoField().setText("");
				internal.getNumeroParcelasField().setText("");
				internalVerCliente.getFinanceiroPanel()
						.carregarTabelas(fachada.buscarContratoPorClienteID(cliente.getId()));

				Menssagens.menssagem("CONTRATO INSERIDO COM SUCESSO.", 1);

			}
		} catch (NumberFormatException e2) {
			Menssagens.menssagem("CERTIFIQUE-SE DE QUE TODOS OS CAMPOS ESTEJAM PREENCHIDOS DE FORMA CORRETA.", 0);
		} catch (BusinessException e2) {
			e2.printStackTrace();
		}

	}

	@Override
	public void addListeners() {
		internal.getBtnSalvar().addActionListener(this);

	}

	public InternalCadastroContrato getInternal() {
		return internal;
	}

	public void setInternal(InternalCadastroContrato internal) {
		this.internal = internal;
	}

}
