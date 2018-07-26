package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalEditarCliente extends InternalCadastroCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalEditarCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
	}

}
