package br.com.fbd_2018_1;

import javax.swing.UIManager;
import br.com.sistema_provedor_fbd_2018_1.controller.Controller;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class App {
	public static void main(String[] args) throws BusinessException {
		String tema_padrao = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(tema_padrao);
		} catch (Exception e) {
		}
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		new Controller(telaPrincipal);

	}

}
