package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.view.AdicionarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class Controller implements ActionListener{
	private TelaPrincipal telaPrincipal;
	public Controller(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;

		telaPrincipal.getBntAdicionarCliente().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==telaPrincipal.getBntAdicionarCliente()) {
				telaPrincipal.desativarBotoes();
				AdicionarCliente adicionarCliente;
				adicionarCliente = new AdicionarCliente(telaPrincipal);
				telaPrincipal.getDesktopPane().add(adicionarCliente);
				adicionarCliente.setVisible(true);
			}
			
			
			
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
	}


}
