package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerServico implements Listeners {
	private Fachada fachada;
	private InternalServicos internalServicos;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroServico controllerCadastroServico;
	private InternalCadastroServico internalCadastroServico;
	private ControllerEditarServico controllerEditarServico;
	private InternalEditarServico internalEditarServico;
	private Servico servico;

	public ControllerServico(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalServicos.getBtnNovo()) {
				controllerCadastroServico = new ControllerCadastroServico(internalServicos);
				internalCadastroServico = new InternalCadastroServico(telaPrincipal, controllerCadastroServico);
				telaPrincipal.getDesktopPane().add(internalCadastroServico);
				internalCadastroServico.setVisible(true);
				controllerCadastroServico.setInternalCadastroServico(internalCadastroServico);
				controllerCadastroServico.addListeners();
			}
			
			if(e.getSource()==internalServicos.getBtnEditar()) {
				int linha = internalServicos.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalServicos.getModelTable().getValueAt(linha, 0).toString());
				
				servico = fachada.buscarServicoPorId(id);
				controllerEditarServico = new ControllerEditarServico(servico);
				internalEditarServico = new InternalEditarServico(telaPrincipal, controllerEditarServico);
				telaPrincipal.getDesktopPane().add(internalEditarServico);
				controllerEditarServico.setInternalEditarServico(internalEditarServico);
				controllerEditarServico.addListeners();
				controllerEditarServico.preencherCampos();
				internalEditarServico.setVisible(true);
			}
			if(e.getSource() == internalServicos.getBtnBuscar()) {
				String busca = internalServicos.getBuscarField().getText();
				
				if(busca.equals("")) {
					internalServicos.carregarServicos(fachada.listarTodosServico());
				}else {
					internalServicos.carregarServicos(fachada.buscarServicoPorBusca(busca));
				}
			}
		} catch (BusinessException e1) {
			e1.getMessage();
		}

	}

	@Override
	public void addListeners() {
		internalServicos.getBtnNovo().addActionListener(this);
		internalServicos.getBtnEditar().addActionListener(this);
		internalServicos.getBtnBuscar().addActionListener(this);

	}

	public InternalServicos getInternalServicos() {
		return internalServicos;
	}

	public void setInternalServicos(InternalServicos internalServicos) {
		this.internalServicos = internalServicos;
	}

}
