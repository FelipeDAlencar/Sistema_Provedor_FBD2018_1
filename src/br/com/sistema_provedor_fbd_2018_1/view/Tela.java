package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Tela extends JFrame{
	public Tela() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		inicializar();
		
	
	}
	
	public abstract void inicializar();
}
