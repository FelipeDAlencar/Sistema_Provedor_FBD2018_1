package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarSwitch;

public class ControllerEditarSwitch implements Listeners {
	private InternalEditarSwitch internalEditarSwitch;
	private Concentrador concentrador;
	private Caixa caixa;
	private Fachada fachada;
	private Switch sw;

	public ControllerEditarSwitch(Switch sw) {
		this.sw = sw;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if (e.getSource()==internalEditarSwitch.getBtnAdicionar()){
			Switch sw = new Switch(
					this.sw.getId(),
					internalEditarSwitch.getNomeField().getText().trim(),
					internalEditarSwitch.getIpField().getText().trim(),
					internalEditarSwitch.getLoginField().getText().trim(),
					new String(internalEditarSwitch.getSenhaField().getPassword()),
					Integer.parseInt(internalEditarSwitch.getNumeroPortasField().getText().trim())
					);
			
				fachada.salvarOuEditarSwitch(sw,
						internalEditarSwitch.getCaixaCombo().getSelectedItem().toString(),
						internalEditarSwitch.getConcentradorCombo().getSelectedItem().toString());
			
		}
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void preencherCampos() {
		try {
			concentrador = fachada.buscarConcentradorPorId(sw.getConcentrador_id());
			caixa = fachada.buscarCaixaPorId(sw.getCaixa_id());
			
			internalEditarSwitch.getNomeField().setText(sw.getNome());
			internalEditarSwitch.getIpField().setText(sw.getIp());
			internalEditarSwitch.getLoginField().setText(sw.getLogin());
			internalEditarSwitch.getSenhaField().setText(sw.getSenha());
			internalEditarSwitch.getNumeroPortasField().setText(String.valueOf(sw.getNumero_de_portas()));
			internalEditarSwitch.getConcentradorCombo().setSelectedItem(concentrador.getNome());
			internalEditarSwitch.getCaixaCombo().setSelectedItem(caixa.getNome());
			
		} catch (BusinessException e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void addListeners() {
		internalEditarSwitch.getBtnAdicionar().addActionListener(this);
	}

	public InternalEditarSwitch getInternalEditarSwitch() {
		return internalEditarSwitch;
	}

	public void setInternalEditarSwitch(InternalEditarSwitch internalEditarSwitch) {
		this.internalEditarSwitch = internalEditarSwitch;
	}






}
