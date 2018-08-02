package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.InternalMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerMovimentacao implements Listeners {
	private TelaPrincipal telaPrincipal;
	private InternalMovimentacao internalMovimentacao;
	private InternalCadastroMovimentacao internalCadastroMovimentacao;
	private InternalEditarMovimentacao internalEditarMovimentacao;
	private ControllerCadastroMovimentacao controllerCadastroMovimentacao;
	private ControllerEditarMovimentacao controllerEditarMovimentacao;
	private Fachada fachada;

	public ControllerMovimentacao(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalMovimentacao.getBtnNovo()) {

				controllerCadastroMovimentacao = new ControllerCadastroMovimentacao(internalMovimentacao);
				internalCadastroMovimentacao = new InternalCadastroMovimentacao(telaPrincipal,
						controllerCadastroMovimentacao);
				telaPrincipal.getDesktopPane().add(internalCadastroMovimentacao);
				internalCadastroMovimentacao.setVisible(true);
				controllerCadastroMovimentacao.setInternal(internalCadastroMovimentacao);
				controllerCadastroMovimentacao.addListeners();

			}

			if (e.getSource() == internalMovimentacao.getBtnEditar()) {
				int linha = internalMovimentacao.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalMovimentacao.getModelTable().getValueAt(linha, 0).toString());

				Movimentacao movimentacao = fachada.buscarPorIdMovimentacao(id);
				controllerEditarMovimentacao = new ControllerEditarMovimentacao(internalMovimentacao, movimentacao);
				internalEditarMovimentacao = new InternalEditarMovimentacao(telaPrincipal,
						controllerEditarMovimentacao);
				telaPrincipal.getDesktopPane().add(internalEditarMovimentacao);
				internalEditarMovimentacao.setVisible(true);
				controllerEditarMovimentacao.setInternal(internalEditarMovimentacao);
				controllerEditarMovimentacao.preencherCampos();
				controllerEditarMovimentacao.addListeners();

			}
			if (e.getSource() == internalMovimentacao.getBtnBuscar()) {
				String busca = internalMovimentacao.getBuscarField().getText();
				if (internalMovimentacao.getRadioPagos().isSelected() && busca.equals("")) {
					internalMovimentacao.carregarMovimentacoes(fachada.buscarPagoOuNao("pago"));

				} else if (internalMovimentacao.getRadioNaoPagos().isSelected() && busca.equals("")) {
					internalMovimentacao.carregarMovimentacoes(fachada.buscarPagoOuNao("Aguardando pagamento"));

				} else if (internalMovimentacao.getRadioPagos().isSelected()) {
					internalMovimentacao.carregarMovimentacoes(fachada.buscarPorBuscaMovimentacao(busca, "Pago"));
					
				} else if(internalMovimentacao.getRadioNaoPagos().isSelected()) {
					internalMovimentacao
							.carregarMovimentacoes(fachada.buscarPorBuscaMovimentacao(busca, "Aguardando pagamento"));
					
				}
			}

		} catch (BusinessException e1) {
			e1.printStackTrace();
		} catch (IndexOutOfBoundsException e2) {
			Menssagens.menssagem("SELECIONE UM CAMPO DA TABELA PARA EDITAR.", 0);
		}

	}

	@Override
	public void addListeners() {
		internalMovimentacao.getBtnBuscar().addActionListener(this);
		internalMovimentacao.getBtnNovo().addActionListener(this);
		internalMovimentacao.getBtnRemover().addActionListener(this);
		internalMovimentacao.getBtnEditar().addActionListener(this);
		internalMovimentacao.getRadioNaoPagos().addActionListener(this);
		internalMovimentacao.getRadioPagos().addActionListener(this);

	}

	public InternalMovimentacao getInternalMovimentacao() {
		return internalMovimentacao;
	}

	public void setInternalMovimentacao(InternalMovimentacao internalMovimentacao) {
		this.internalMovimentacao = internalMovimentacao;
	}

}
