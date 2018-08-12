package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarServicoCliente;

public class ControllerEditarServicoCliente  implements Listeners{
	private InternalEditarServicoCliente internalEditarServicoCliente;
	private ServicoCliente servicoCliente;
	public ControllerEditarServicoCliente(ServicoCliente servico) {
		this.servicoCliente = servico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalEditarServicoCliente.getBtnSalvar()) {
			
		}
	}

	@Override
	public void addListeners() {
		internalEditarServicoCliente.getBtnSalvar().addActionListener(this);
	}
	
	public void setInternalEditarServicoCliente(InternalEditarServicoCliente internalEditarServicoCliente) {
		this.internalEditarServicoCliente = internalEditarServicoCliente;
	}
	
	public void preencherCampos() {
		IFachada fachada = new Fachada();
		try {
		Endereco endereco = fachada.buscarEnderecoPorId(servicoCliente.getEndereco_id());
		Switch sw = fachada.buscarSwitchPorId(servicoCliente.getSwitch_id());
		Porta porta = fachada.buscarPortaPorId(servicoCliente.getPorta_id());
		Servico servico = fachada.buscarServicoPorId(servicoCliente.getServico_id());
	
		internalEditarServicoCliente.getBairroField().setText(endereco.getBairro());
		internalEditarServicoCliente.getComplementoField().setText(endereco.getComplemento());
		internalEditarServicoCliente.getNumeroField().setText(String.valueOf(endereco.getNumero()));
		internalEditarServicoCliente.getRuaField().setText(endereco.getRua());
		internalEditarServicoCliente.getLoginField().setText(servicoCliente.getLogin());
		internalEditarServicoCliente.getSenhaField().setText(servicoCliente.getSenha());
		internalEditarServicoCliente.getPortaComboBox().setSelectedItem(porta.getNumero());
		internalEditarServicoCliente.getServicosComboBox().setSelectedItem(servico.getNome());
		internalEditarServicoCliente.getSwitchComboBox().setSelectedItem(sw.getNome());
		
		
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
