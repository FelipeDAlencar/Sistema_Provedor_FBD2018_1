package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalEditarConcentrador extends InternalCadastroConcentrador{

	private static final long serialVersionUID = 1L;

	public InternalEditarConcentrador(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super(telaPrincipal, actionListener);
		getBtnAdicionar().setBounds(537, 272, 162, 40);
		setTitle("Editar Concentrador");
		getBtnAdicionar().setText("Editar Concentrador");
		
	}
	
	

}
