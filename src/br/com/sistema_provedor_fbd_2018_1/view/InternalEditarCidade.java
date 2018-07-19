package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InternalEditarCidade extends InternalCadastroCidade {

	public InternalEditarCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		getBtnAdd().setText("Editar Cidade");

	}	
}
