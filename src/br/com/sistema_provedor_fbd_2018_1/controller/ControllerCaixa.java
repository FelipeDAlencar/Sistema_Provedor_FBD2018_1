package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCaixa;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCaixa implements Listeners {
	private InternalCaixa internalCaixa;
	private TelaPrincipal telaPrincipal;
	private InternalCadastroCaixa internalCadastroCaixa;
	private ControllerCadastroCaixa controllerCadastroCaixa;
	private ControllerEditarCaixa controllerEditarCaixa;
	private InternalEditarCaixa internalEditarCaixa;
	private Fachada fachada;

	public ControllerCaixa(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internalCaixa.getBtnNovo()) {


				controllerCadastroCaixa = new ControllerCadastroCaixa(internalCaixa);
				internalCadastroCaixa = new InternalCadastroCaixa(telaPrincipal, controllerCadastroCaixa);
				telaPrincipal.getDesktopPane().add(internalCadastroCaixa);
				internalCadastroCaixa.setVisible(true);
				controllerCadastroCaixa.setInternalCadastroCaixa(internalCadastroCaixa);
				System.out.println(internalCadastroCaixa);
				controllerCadastroCaixa.addListeners();

			}

			if(e.getSource() == internalCaixa.getBtnEditar()) {
				int row = internalCaixa.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalCaixa.getTabela().getValueAt(row,0).toString());
				Caixa caixa = fachada.buscarCaixaPorId(id);

				controllerEditarCaixa = new ControllerEditarCaixa(caixa);
				internalEditarCaixa = new InternalEditarCaixa(telaPrincipal, controllerEditarCaixa);
				telaPrincipal.getDesktopPane().add(internalEditarCaixa);
				internalEditarCaixa.setVisible(true);
				controllerEditarCaixa.setInternalEditarCaixa(internalEditarCaixa);
				controllerEditarCaixa.addListeners();
				controllerEditarCaixa.preencherCampos();
			}
			
			if(e.getSource() == internalCaixa.getBtnBuscar()) {
				
				String busca = internalCaixa.getBuscarField().getText();
				
				if(busca.equals("")) {
					internalCaixa.carregarcaixa(fachada.listarTodosCaixa());
				}else {
					internalCaixa.carregarcaixa(fachada.buscarCaixaPorBusca(busca));
				}
				
				
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}


	}

	@Override
	public void addListeners() {
		internalCaixa.getBtnNovo().addActionListener(this);
		internalCaixa.getBtnEditar().addActionListener(this);
		internalCaixa.getBtnBuscar().addActionListener(this);

	}

	public InternalCaixa getInternalCaixa() {
		return internalCaixa;
	}

	public void setInternalCaixa(InternalCaixa internalCaixa) {
		this.internalCaixa = internalCaixa;
	}


}
