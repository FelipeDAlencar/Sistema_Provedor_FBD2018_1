package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalEditarFuncionario extends InternalCadastroFuncionario{

	public InternalEditarFuncionario(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super(telaPrincipal, actionListener);
		setTitle("Editar Funcionario");
		
	}

}
