package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalEditarServico extends InternalCadastroServico {

	public InternalEditarServico(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		setTitle("Editar Serviço");
		getBtnInserirServio().setText("Editar Serviço");

	}	
}
