package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JOptionPane;

public class Messagens {
	public Messagens() {
		
	}
	public static void messagem(String txt, int tipo) {
		JOptionPane.showMessageDialog(null, txt, "", tipo);
		
	}

}
