package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.InternalMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroMovimentacao implements Listeners {
	private InternalMovimentacao internalMovimentacao;
	private InternalCadastroMovimentacao internal;
	private Fachada fachada;
	
	public ControllerCadastroMovimentacao(InternalMovimentacao internalMovimentacao) {
		fachada = new Fachada();
		this.internalMovimentacao = internalMovimentacao;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internal.getBtnSalvar()) {
				Movimentacao movimentacao = new Movimentacao( internal.getDescricaoField().getText(), "Aguardando pagamento", 
						String.valueOf(internal.getTipocomboBox().getSelectedItem()), internal.getDataMovimentacaoField().getText(), Double.parseDouble(internal.getValorField().getText()),true);
			
				fachada.salvarOuEditarMovimentacao(movimentacao);
				internalMovimentacao.carregarMovimentacoes(fachada.listarTodosMovimentacao());
				
				Menssagens.menssagem("Movimentação inserida com sucesso.", 1);
				
				internal.getDescricaoField().setText("");
				internal.getDataMovimentacaoField().setText("");
				internal.getValorField().setText("");
			
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}

	@Override
	public void addListeners() {
		internal.getBtnSalvar().addActionListener(this);
	}

	public InternalCadastroMovimentacao getInternal() {
		return internal;
	}

	public void setInternal(InternalCadastroMovimentacao internal) {
		this.internal = internal;
	}
	

}
