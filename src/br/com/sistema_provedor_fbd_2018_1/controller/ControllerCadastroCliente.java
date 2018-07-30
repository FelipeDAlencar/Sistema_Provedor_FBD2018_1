package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalLocalizarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCadastroCliente implements Listeners {
	private InternalCadastroCliente internalCliente;
	private Fachada fachada;
	private ControllerCadastroContato controllerCadastroContato;
	private ControllerEditarContato controllerEditarContato;
	private InternalCadastroContato internalCadastroContato;
	private InternalEditarContato internalEditarContato;
	private TelaPrincipal telaPrincipal;
	private Cliente cliente;
	private ControllerVerCliente controllerVerCliente;
	private InternalVerCliente internalVerCliente;

	public ControllerCadastroCliente(TelaPrincipal telaPrincipal) {
		fachada = new Fachada();
		this.telaPrincipal = telaPrincipal;
		controllerCadastroContato = new ControllerCadastroContato(internalCliente);
	}

	public ControllerCadastroCliente() {
		fachada = new Fachada();
		controllerCadastroContato = new ControllerCadastroContato(internalCliente);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalCliente.getBtnSalvar()) {


				if (controllerCadastroContato.getContatos().isEmpty() == false) {
					cliente = new Cliente(
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



					if (controllerCadastroContato != null) {
						controllerCadastroContato.setContatos(new ArrayList<>());
					}
					Menssagens.menssagem("Cliente Adicionado com sucesso.", 1);

					VerCliente();

				} else {
					throw new BusinessException("CLIENTE TEM QUE TER AO MENOS UM CONTATO CADASTRADO.");
				}


			}

			if (e.getSource() == internalCliente.getPanelContatos().getBntAdicionar()) {


				controllerCadastroContato = new ControllerCadastroContato(internalCliente);
				internalCadastroContato = new InternalCadastroContato(telaPrincipal, controllerCadastroContato);
				telaPrincipal.getDesktopPane().add(internalCadastroContato);
				internalCadastroContato.setVisible(true);
				controllerCadastroContato.setInternalCadastroContato(internalCadastroContato);
				controllerCadastroContato.addListeners();



			}

			if (e.getSource() == internalCliente.getPanelContatos().getBntEditar()) {

				int linha = internalCliente.getPanelContatos().getTabela().getSelectedRow();
				controllerEditarContato = new ControllerEditarContato(controllerCadastroContato.getContatos(), linha,
						internalCliente);
				internalEditarContato = new InternalEditarContato(telaPrincipal, controllerEditarContato);
				telaPrincipal.getDesktopPane().add(internalEditarContato);
				internalEditarContato.setVisible(true);
				controllerEditarContato.setInternalEditarContato(internalEditarContato);
				controllerEditarContato.PreencerCampos();
				controllerEditarContato.addListeners();


			}


		} catch (BusinessException e1) {
			e1.printStackTrace();
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

	private void VerCliente() {
		try {
			internalCliente.dispose();
			controllerVerCliente = new ControllerVerCliente(telaPrincipal, cliente);
			internalVerCliente = new InternalVerCliente(telaPrincipal, controllerVerCliente);
			telaPrincipal.getDesktopPane().add(internalVerCliente);
			internalVerCliente.setVisible(true);
			controllerVerCliente.setInternalVerCliente(internalVerCliente);
			controllerVerCliente.addListeners();
			controllerVerCliente.carregarDados();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
