package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JOptionPane;

public class Menssagens {
	public Menssagens() {
		
	}
	public static void menssagem(String txt, int tipo) {
		JOptionPane.showMessageDialog(null, txt, "", tipo);
		
	}

}
