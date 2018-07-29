package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente{
	private JPanel servico, financeiro, atendimentos;

	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		servico = new JPanel();
		financeiro = new JPanel();
		atendimentos= new JPanel();
		
		getTabbedPane().add("Serviço", servico);
		getTabbedPane().add("Financeiro", financeiro);
		getTabbedPane().add("Atendimentos", atendimentos);
	}

	
}
