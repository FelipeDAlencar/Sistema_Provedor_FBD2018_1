package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalEditarCaixa extends InternalCadastroCaixa{

	private static final long serialVersionUID = 1L;

	public InternalEditarCaixa(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super(telaPrincipal, actionListener);
		setTitle("Editar Caixa");
		getBtnCadastrar().setText("Editar Caixa");
		
	}
	
	

}
