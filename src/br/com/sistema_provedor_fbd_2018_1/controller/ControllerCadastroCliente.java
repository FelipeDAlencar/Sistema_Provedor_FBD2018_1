package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil.Cliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarCliente;

public class ControllerCadastroCliente implements ActionListener {
	private InternalAdicionarCliente adicionarCliente;
	private Fachada fachada;

	public ControllerCadastroCliente(InternalAdicionarCliente internalAdicionarCliente) {
		fachada = new Fachada();
	}

	public ControllerCadastroCliente() {
		fachada = new Fachada();
	}

	public void addListenners() {
		adicionarCliente.getBtnSalvar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionarCliente.getBtnSalvar()) {
			br.com.sistema_provedor_fbd_2018_1.entidade.Cliente cliente = new br.com.sistema_provedor_fbd_2018_1.entidade.Cliente(
					adicionarCliente.getNomeField().getText(), adicionarCliente.getCpfField().getText(),
					adicionarCliente.getRgField().getText(), adicionarCliente.getDataNascimentoField().getText());

			Endereco endereco = new Endereco(adicionarCliente.getBairroField().getText(),
					adicionarCliente.getComplementoField().getText(), adicionarCliente.getRuaField().getText(),
					Integer.parseInt(adicionarCliente.getNumeroField().getText()));

			try {
				fachada.salvarOuEditarEndereco(endereco);
				fachada.salvarOuEditarCliente(cliente);
			} catch (BusinessException e1) {
				e1.printStackTrace();
			}
		}

	}

	public InternalAdicionarCliente getAdicionarCliente() {
		return adicionarCliente;
	}

	public void setAdicionarCliente(InternalAdicionarCliente adicionarCliente) {
		this.adicionarCliente = adicionarCliente;
	}

}
