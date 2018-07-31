package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente{
	private JPanel financeiro, atendimentos;
	private PanelServico panelServico;
	private PanelContrato panelContrato;

	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		financeiro = new JPanel();
		atendimentos= new JPanel();
		
		panelServico = new PanelServico();
		panelServico.getBarraRolagem().setBounds(50, 60, 940, 269);
		
		panelContrato = new PanelContrato();
		panelContrato.getBarraRolagem().setBounds(50, 60, 940, 269);
		
		getTabbedPane().add("Serviço", panelServico);
		getTabbedPane().add("Financeiro", financeiro);
		getTabbedPane().add("Atendimentos", atendimentos);
	}

	public JPanel getFinanceiro() {
		return financeiro;
	}

	public JPanel getAtendimentos() {
		return atendimentos;
	}

	public PanelServico getPanelServico() {
		return panelServico;
	}

	public PanelContrato getPanelContrato() {
		return panelContrato;
	}
	
	

}
