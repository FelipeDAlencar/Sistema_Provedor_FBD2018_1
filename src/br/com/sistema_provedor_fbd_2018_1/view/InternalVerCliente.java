package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalVerCliente extends InternalCadastroCliente{
	private JPanel financeiro, atendimentos;

	public InternalVerCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		financeiro = new JPanel();
		atendimentos= new JPanel();
		
		getTabbedPane().add("Financeiro", financeiro);
		getTabbedPane().add("Atendimentos", atendimentos);
	}

	
}
