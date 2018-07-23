package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerConcentrador implements Listeners {
	private Fachada fachada;
	private TelaPrincipal telaPrincipal;
	private InternalConcentrador internalConcentrador;
	private InternalCadastroConcentrador internalCadastroConcentrador;
	private ControllerCadastroConcentrador controllerCadastroConcentrador;
	private ControllerEditarConcentrador controllerEditarConcentrador;
	private InternalEditarConcentrador internalEditarConcentrador;
	
	public ControllerConcentrador(TelaPrincipal telaPrincipal) {
		this.telaPrincipal= telaPrincipal;
		fachada = new Fachada();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource() == internalConcentrador.getBtnNovo()) {
			controllerCadastroConcentrador = new ControllerCadastroConcentrador();
			internalCadastroConcentrador = new InternalCadastroConcentrador(telaPrincipal, controllerCadastroConcentrador);
			telaPrincipal.getDesktopPane().add(internalCadastroConcentrador);
			internalCadastroConcentrador.setVisible(true);
			controllerCadastroConcentrador.setInternalCadastroConcentrador(internalCadastroConcentrador);
			controllerCadastroConcentrador.addListeners();			
		}
		
		if(e.getSource()==internalConcentrador.getBtnEditar()) {
			int linha = internalConcentrador.getTabela().getSelectedRow();
			int id = Integer.parseInt(internalConcentrador.getModelTable().getValueAt(linha, 0).toString());
			
			Concentrador concentrador = fachada.buscarConcentradorPorId(id);
			
			controllerEditarConcentrador = new ControllerEditarConcentrador(concentrador);
			internalEditarConcentrador = new InternalEditarConcentrador(telaPrincipal, controllerEditarConcentrador);
			controllerEditarConcentrador.setInternalEditarConcentrador(internalEditarConcentrador);
			controllerEditarConcentrador.addListeners();
			controllerEditarConcentrador.preencherCampos();
			telaPrincipal.getDesktopPane().add(internalEditarConcentrador);
			internalEditarConcentrador.setVisible(true);
		}
		
		} catch (BusinessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

	@Override
	public void addListeners() {
		internalConcentrador.getBtnNovo().addActionListener(this);
		internalConcentrador.getBtnEditar().addActionListener(this);
		internalConcentrador.getBtnRemover().addActionListener(this);
		
	}

	public InternalConcentrador getInternalConcentrador() {
		return internalConcentrador;
	}

	public void setInternalConcentrador(InternalConcentrador internalConcentrador) {
		this.internalConcentrador = internalConcentrador;
	}
	

}
