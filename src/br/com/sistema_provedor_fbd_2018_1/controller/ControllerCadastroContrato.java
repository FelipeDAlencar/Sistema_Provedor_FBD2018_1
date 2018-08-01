package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContrato;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroContrato implements Listeners {
	private Fachada fachada;
	private InternalCadastroContrato internal;
	private Cliente cliente;

	public ControllerCadastroContrato(Cliente cliente) {
		this.cliente = cliente;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internal.getBtnSalvar()) {

				Contrato contrato = new Contrato(cliente.getId(),
						Double.parseDouble(internal.getValorInstalacaoField().getText()),
						Double.parseDouble(internal.getValorMensalField().getText()),
						internal.getLoginField().getText(), internal.getSenhaField().getText(),
						Integer.parseInt(internal.getNumeroParcelasField().getText()));

				Parcela parcela = new Parcela(contrato.getValor_mensal(), internal.getDataVencimentoField().getText(),
						true);

				fachada.salvarOuEditarContrato(contrato, parcela);
				
				internal.getValorInstalacaoField().setText("");
				internal.getValorMensalField().setText("");
				internal.getLoginField().setText("");
				internal.getSenhaField().setText("");
				internal.getDataVencimentoField().setText("");
				internal.getNumeroParcelasField().setText("");
				
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
