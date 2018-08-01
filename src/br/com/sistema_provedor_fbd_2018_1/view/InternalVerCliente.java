package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente {
	private JPanel atendimentos;
	private PanelFinanceiro financeiro;
	private PanelServico panelServico;
	private JScrollPane scrollFinanceiro;

	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		
		setResizable(true);
		getTabbedPane().setSize(1000,350);
		financeiro = new PanelFinanceiro();
		financeiro.setPreferredSize(new Dimension(800, 600));
		financeiro.setLayout(null);
		
		scrollFinanceiro = new JScrollPane(financeiro);
		
		scrollFinanceiro.setPreferredSize(new Dimension(300, 300));  
        scrollFinanceiro.setVerticalScrollBarPolicy(scrollFinanceiro.VERTICAL_SCROLLBAR_ALWAYS);  
        scrollFinanceiro.setHorizontalScrollBarPolicy(scrollFinanceiro.HORIZONTAL_SCROLLBAR_ALWAYS);  
  	
		atendimentos = new JPanel();

		panelServico = new PanelServico();
		//panelServico.getBarraRolagem().setBounds(50, 60, 940, 269);
		
		

		getTabbedPane().add("Serviço", panelServico);
		getTabbedPane().add("Financeiro", scrollFinanceiro);
		getTabbedPane().add("Atendimentos", atendimentos);
		
	}

	public PanelFinanceiro getFinanceiro() {
		return financeiro;
	}

	public JPanel getAtendimentos() {
		return atendimentos;
	}

	public PanelServico getPanelServico() {
		return panelServico;
	}

}
