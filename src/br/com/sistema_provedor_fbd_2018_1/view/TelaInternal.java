package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public abstract class TelaInternal extends JInternalFrame{
	TelaPrincipal telaPrincipal;
	public static int LARGURA = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int ALTURA = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public TelaInternal(String titulo, TelaPrincipal telaPrincipal) throws BusinessException {
		this.telaPrincipal=telaPrincipal;
		setSize(LARGURA-50, ALTURA-150);
		setLocation(25,25);
		setTitle(titulo);
		setResizable(false);
		setClosable(true);
		setMaximizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		

		inicializar();
		
		setVisible(true);
	}
	
	@Override
	public void doDefaultCloseAction() {
		super.doDefaultCloseAction();
		telaPrincipal.ativarBotoes();
	}
	public abstract void inicializar() throws BusinessException;
}
