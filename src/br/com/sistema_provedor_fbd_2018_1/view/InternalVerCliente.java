package br.com.sistema_provedor_fbd_2018_1.view;


import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente {
	private PanelAtendimento panelAtendimento;
	private PanelFinanceiro panelFinanceiro;
	private PanelServico panelServico;
	private JScrollPane scrollFinanceiro;


	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);

		setResizable(true);
		getTabbedPane().setSize(1000, 350);
		panelFinanceiro = new PanelFinanceiro();
		panelFinanceiro.setPreferredSize(new Dimension(1000, 2000));
		panelAtendimento = new PanelAtendimento();

		panelServico = new PanelServico();
		
		scrollFinanceiro = new JScrollPane(panelFinanceiro);
		scrollFinanceiro.setPreferredSize(new Dimension(1000, 2000));
		getTabbedPane().add("Serviço", panelServico);
		getTabbedPane().add("Financeiro", scrollFinanceiro);
		getTabbedPane().add("Atendimentos", panelAtendimento);

	}



	public PanelAtendimento getPanelAtendimento() {
		return panelAtendimento;
	}



	public PanelFinanceiro getPanelFinanceiro() {
		return panelFinanceiro;
	}



	public PanelServico getPanelServico() {
		return panelServico;
	}
	
}
