package br.com.sistema_provedor_fbd_2018_1.view;


import java.awt.event.ActionListener;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente {
	private PanelAtendimento panelAtendimento;
	private PanelFinanceiro panelFinanceiro;
	private PanelServico panelServico;
	


	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);

		setResizable(true);
		getTabbedPane().setSize(1000, 350);
		panelFinanceiro = new PanelFinanceiro();

		panelAtendimento = new PanelAtendimento();

		panelServico = new PanelServico();

		getTabbedPane().add("Serviço", panelServico);
		getTabbedPane().add("Financeiro", panelFinanceiro);
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
