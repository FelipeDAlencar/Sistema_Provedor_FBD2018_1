package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarContato;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaInternal;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCliente implements Listeners {
	private InternalCadastroCliente internalCliente;
	private Fachada fachada;
	private ControllerCadastroContato controllerCadastroContato;
	private ControllerEditarContato controllerEditarContato;
	private InternalCadastroContato internalCadastroContato;
	private InternalEditarContato internalEditarContato;
	private TelaPrincipal telaPrincipal;

	public ControllerCliente(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;
		controllerCadastroContato = new ControllerCadastroContato(internalCliente);
	}

	public ControllerCliente() {
		fachada = new Fachada();
		controllerCadastroContato = new ControllerCadastroContato(internalCliente);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == internalCliente.getBtnSalvar()) {
			try {

				if (controllerCadastroContato.getContatos().isEmpty() == false) {
					br.com.sistema_provedor_fbd_2018_1.entidade.Cliente cliente = new br.com.sistema_provedor_fbd_2018_1.entidade.Cliente(
							internalCliente.getNomeField().getText(), internalCliente.getCpfField().getText(),
							internalCliente.getRgField().getText(), internalCliente.getDataNascimentoField().getText());
					
					Endereco endereco = new Endereco(internalCliente.getBairroField().getText(),
							internalCliente.getComplementoField().getText(), internalCliente.getRuaField().getText(),
							Integer.parseInt(internalCliente.getNumeroField().getText()));
					
					
					String cidadeString = (String)internalCliente.getCidadesComboBox().getSelectedItem();
					
					String nomeCidade = Ultil.separarString(cidadeString.trim(), 0);
					String estado = Ultil.separarString(cidadeString.trim(), 1);
					
					
					
					Cidade  cidade = fachada.buscarPorNomeEstado(nomeCidade, estado);
					
					fachada.salvarOuEditarCliente(cliente, endereco, cidade.getCep());

					for (Contato contato : controllerCadastroContato.getContatos()) {
						fachada.salvarOuEditarContato(contato, cliente.getCpf());
					}

					internalCliente.getNomeField().setText("");
					internalCliente.getRgField().setText("");
					internalCliente.getDataNascimentoField().setText("");
					internalCliente.getComplementoField().setText("");
					internalCliente.getBairroField().setText("");
					internalCliente.getRuaField().setText("");
					internalCliente.getNumeroField().setText("");

					if (controllerCadastroContato != null) {
						controllerCadastroContato.setContatos(new ArrayList<>());
					}
					Menssagens.menssagem("Cliente Adicionado com sucesso.", 1);
				} else {
					throw new BusinessException("CLIENTE TEM QUE TER AO MENOS UM CONTATO CADASTRADO.");
				}

			} catch (BusinessException e1) {
				e1.printStackTrace();

			}
		}

		if (e.getSource() == internalCliente.getPanelContatos().getBntAdicionar()) {
			try {

				controllerCadastroContato = new ControllerCadastroContato(internalCliente);
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

		if (e.getSource() == internalCliente.getPanelContatos().getBntEditar()) {
			try {
				int linha = internalCliente.getPanelContatos().getTabela().getSelectedRow();
				controllerEditarContato = new ControllerEditarContato(controllerCadastroContato.getContatos(), linha,
						internalCliente);
				internalEditarContato = new InternalEditarContato(telaPrincipal, controllerEditarContato);
				telaPrincipal.getDesktopPane().add(internalEditarContato);
				internalEditarContato.setVisible(true);
				controllerEditarContato.setInternalEditarContato(internalEditarContato);
				controllerEditarContato.PreencerCampos();
				controllerEditarContato.addListeners();

			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	@Override
	public void addListeners() {
		internalCliente.getBtnSalvar().addActionListener(this);
		internalCliente.getPanelContatos().getBntAdicionar().addActionListener(this);
		internalCliente.getPanelContatos().getBntEditar().addActionListener(this);

	}

	public InternalCadastroCliente getAdicionarCliente() {
		return internalCliente;
	}

	public void setAdicionarCliente(InternalCadastroCliente adicionarCliente) {
		this.internalCliente = adicionarCliente;
	}
	

}
