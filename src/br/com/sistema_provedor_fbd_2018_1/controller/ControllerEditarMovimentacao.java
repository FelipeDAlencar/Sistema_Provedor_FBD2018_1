package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.Calendar;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.InternalMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarMovimentacao implements Listeners {
	private InternalEditarMovimentacao internal;
	private InternalMovimentacao internalMovimentacao;
	private Fachada fachada;
	private Movimentacao movimentacao;
	
	public ControllerEditarMovimentacao(InternalMovimentacao internalMovimentacao,Movimentacao movimentacao) {
		fachada = new Fachada();
		this.internalMovimentacao = internalMovimentacao;
		this.movimentacao = movimentacao;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internal.getBtnSalvar()) {
				
				Movimentacao movimentacao = new Movimentacao( this.movimentacao.getId(), internal.getDescricaoField().getText(), String.valueOf(internal.getSituacaoComboBox().getSelectedItem()), 
						String.valueOf(internal.getTipocomboBox().getSelectedItem()), Ultil.converterJavaDateEmString(internal.getDataMovimentacaoField().getDate()), Double.parseDouble(internal.getValorField().getText()),true);
			
				
				fachada.salvarOuEditarMovimentacao(movimentacao);
				
				
				internalMovimentacao.carregarMovimentacoes(fachada.listarTodosMovimentacao());
				
				Menssagens.menssagem("Movimentação inserida com sucesso.", 1);
				
				internal.getDescricaoField().setText("");
				
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
	public void preencherCampos() {
		Calendar calendar = Ultil.pegarDataParaEdicao(movimentacao.getData_movimentacao());
		internal.getDescricaoField().setText(movimentacao.getDescricao());
		internal.getValorField().setText(String.valueOf(movimentacao.getValor()));
		internal.getDataMovimentacaoField().setCalendar(calendar);;
	}

	public InternalEditarMovimentacao getInternal() {
		return internal;
	}

	public void setInternal(InternalEditarMovimentacao internal) {
		this.internal = internal;
	}
	

}
