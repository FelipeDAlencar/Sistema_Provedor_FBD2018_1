package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalEditarFuncionario extends InternalCadastroFuncionario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalEditarFuncionario(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super(telaPrincipal, actionListener);
		getBtnAdicionar().setBounds(876, 368, 126, 29);
		getBtnAdicionar().setText("Editar Funcionario");
		
	}
	
	

}
