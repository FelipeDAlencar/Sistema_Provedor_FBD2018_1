package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaInternal;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCliente implements Listeners {
	private InternalCadastroCliente adicionarCliente;
	private Fachada fachada;
	private ControllerCadastroContato controllerCadastroContato;
	private InternalCadastroContato internalCadastroContato;
	private TelaPrincipal telaPrincipal;

	public ControllerCliente(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;
		controllerCadastroContato =  new ControllerCadastroContato();
	}

	public ControllerCliente() {
		fachada = new Fachada();
		controllerCadastroContato =  new ControllerCadastroContato();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == adicionarCliente.getBtnSalvar()) {
			try {

				if (controllerCadastroContato.getContatos().isEmpty() == false) {
					br.com.sistema_provedor_fbd_2018_1.entidade.Cliente cliente = new br.com.sistema_provedor_fbd_2018_1.entidade.Cliente(
							adicionarCliente.getNomeField().getText(), adicionarCliente.getCpfField().getText(),
							adicionarCliente.getRgField().getText(),
							adicionarCliente.getDataNascimentoField().getText());

					Endereco endereco = new Endereco(adicionarCliente.getBairroField().getText(),
							adicionarCliente.getComplementoField().getText(), adicionarCliente.getRuaField().getText(),
							Integer.parseInt(adicionarCliente.getNumeroField().getText()));

					fachada.salvarOuEditarEndereco(endereco);
					fachada.salvarOuEditarCliente(cliente);

					for (Contato contato : controllerCadastroContato.getContatos()) {
						fachada.salvarOuEditarContato(contato, cliente.getCpf());
					}

					adicionarCliente.getNomeField().setText("");
					adicionarCliente.getRgField().setText("");
					adicionarCliente.getDataNascimentoField().setText("");
					adicionarCliente.getComplementoField().setText("");
					adicionarCliente.getBairroField().setText("");
					adicionarCliente.getRuaField().setText("");
					adicionarCliente.getNumeroField().setText("");

					Menssagens.menssagem("Cliente Adicionado com sucesso.", 1);
				} else {
					throw new BusinessException("CLIENTE TEM QUE TER AO MENOS UM CONTATO CADASTRADO.");
				}

			} catch (BusinessException e1) {
				e1.printStackTrace();
				

			}
		}

		if (e.getSource() == adicionarCliente.getPanelContatos().getBntAdicionar()) {
			try {
				controllerCadastroContato = new ControllerCadastroContato();
				internalCadastroContato = new InternalCadastroContato(telaPrincipal, controllerCadastroContato);
				telaPrincipal.getDesktopPane().add(internalCadastroContato);
				internalCadastroContato.setVisible(true);
				controllerCadastroContato.setInternalCadastroContato(internalCadastroContato);
				controllerCadastroContato.addListeners();

			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public InternalCadastroCliente getAdicionarCliente() {
		return adicionarCliente;
	}

	public void setAdicionarCliente(InternalCadastroCliente adicionarCliente) {
		this.adicionarCliente = adicionarCliente;
	}

	@Override
	public void addListeners() {
		adicionarCliente.getBtnSalvar().addActionListener(this);
		adicionarCliente.getPanelContatos().getBntAdicionar().addActionListener(this);

	}

}
