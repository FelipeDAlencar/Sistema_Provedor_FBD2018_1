package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerCidade implements Listeners {
	private InternalCidade internalCidade;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroCidade controllerCadastroCidade;
	private InternalCadastroCidade internalCadastroCidade;
	private ControllerEditarCidade controllerEditarCidade;
	private InternalEditarCidade internalEditarCidade;
	private Fachada fachada;

	public ControllerCidade(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalCidade.getBntNovo()) {

				controllerCadastroCidade = new ControllerCadastroCidade(internalCidade);
				internalCadastroCidade = new InternalCadastroCidade(telaPrincipal, controllerCadastroCidade);
				telaPrincipal.getDesktopPane().add(internalCadastroCidade);
				controllerCadastroCidade.setInternalCadastroCidade(internalCadastroCidade);
				internalCadastroCidade.setVisible(true);
				controllerCadastroCidade.setInternalCadastroCidade(internalCadastroCidade);
				controllerCadastroCidade.addListeners();
			}
			if (e.getSource() == internalCidade.getBntEditar()) {

				int row = internalCidade.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalCidade.getTabela().getValueAt(row, 0).toString());
				Cidade cidade = fachada.buscarCidadePorId(id);

				controllerEditarCidade = new ControllerEditarCidade(internalCidade, cidade);
				internalEditarCidade = new InternalEditarCidade(telaPrincipal, controllerEditarCidade);
				telaPrincipal.getDesktopPane().add(internalEditarCidade);
				internalEditarCidade.setVisible(true);
				controllerEditarCidade.setInternalEditarCidade(internalEditarCidade);
				controllerEditarCidade.addListeners();
				controllerEditarCidade.carregarDados();

			}
			if (e.getSource() == internalCidade.getBtnBuscar()) {
				String busca = internalCidade.getBuscaField().getText();
				System.out.println("Entrou");

				if (busca.equals("")) {
					internalCidade.carregarCidades(fachada.listarTodosCidades());
				} else {
					internalCidade.carregarCidades(fachada.buscarCidadePorBusca(busca));
				}
			}
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IndexOutOfBoundsException e2) {
			Menssagens.menssagem("SELECIONE UM CAMPO DA TABELA PARA EDITAR.", 0);
		}

	}

	@Override
	public void addListeners() {
		internalCidade.getBntNovo().addActionListener(this);
		internalCidade.getBntEditar().addActionListener(this);
		internalCidade.getBtnBuscar().addActionListener(this);
	}

	public InternalCidade getInternalCidade() {
		return internalCidade;
	}

	public void setInternalCidade(InternalCidade internalCidade) {
		this.internalCidade = internalCidade;
	}

}
