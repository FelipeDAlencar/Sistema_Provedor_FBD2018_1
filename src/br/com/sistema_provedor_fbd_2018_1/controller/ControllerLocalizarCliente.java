package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalLocalizarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerLocalizarCliente implements Listeners {
	private InternalLocalizarCliente internalLocalizarCliente;
	private ControllerVerCliente controllerVerCliente;
	private InternalVerCliente internalVerCliente;
	private TelaPrincipal telaPrincipal;
	private Fachada fachada;

	public ControllerLocalizarCliente(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internalLocalizarCliente.getBtnBuscar()) {
				String busca = internalLocalizarCliente.getBuscarField().getText();
				internalLocalizarCliente.carregarClientes(fachada.buscarClientePorBusca(busca));
			}
			if (e.getSource() == internalLocalizarCliente.getBtnEditar()) {
				
				int row = internalLocalizarCliente.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalLocalizarCliente.getTabela().getValueAt(row, 0).toString());
				Cliente cliente = fachada.buscarClientePorId(id);
				controllerVerCliente = new ControllerVerCliente(telaPrincipal, cliente);
				internalVerCliente = new InternalVerCliente(telaPrincipal, controllerVerCliente);
				telaPrincipal.getDesktopPane().add(internalVerCliente);
				internalVerCliente.setVisible(true);
				controllerVerCliente.setInternalVerCliente(internalVerCliente);
				controllerVerCliente.addListeners();
				controllerVerCliente.carregarDados();
				internalVerCliente.getFinanceiroPanel().carregarTabelas(fachada.buscarContratoPorClienteID(cliente.getId()));
			

			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}catch (IndexOutOfBoundsException e2) {
			e2.printStackTrace();
			Menssagens.menssagem("SELECIONE O CLIENTE NA TABELA." , 0);
		}

	}

	@Override
	public void addListeners() {
		internalLocalizarCliente.getBtnBuscar().addActionListener(this);
		internalLocalizarCliente.getBtnEditar().addActionListener(this);

	}

	public InternalLocalizarCliente getInternalLocalizarCliente() {
		return internalLocalizarCliente;
	}

	public void setInternalLocalizarCliente(InternalLocalizarCliente internalLocalizarCliente) {
		this.internalLocalizarCliente = internalLocalizarCliente;
	}



}
