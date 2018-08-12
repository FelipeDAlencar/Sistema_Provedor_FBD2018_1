package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.InternalFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerFuncionario implements Listeners {
	private InternalFuncionario internalFuncionario;
	private InternalCadastroFuncionario internalCadastroFuncionario;
	private TelaPrincipal telaPrincipal;
	private ControllerCadastroFuncionario controllerCadastroFuncionario;
	private ControllerEditarFuncionario controllerEditarFuncionario;
	private InternalEditarFuncionario internalEditarFuncionario;
	private Fachada fachada;

	public ControllerFuncionario(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalFuncionario.getBntNovo()) {

				controllerCadastroFuncionario = new ControllerCadastroFuncionario(internalFuncionario);
				internalCadastroFuncionario = new InternalCadastroFuncionario(telaPrincipal,
						controllerCadastroFuncionario);
				telaPrincipal.getDesktopPane().add(internalCadastroFuncionario);
				internalCadastroFuncionario.setVisible(true);
				controllerCadastroFuncionario.setInternalCadastroFuncionario(internalCadastroFuncionario);
				controllerCadastroFuncionario.addListeners();

			}
			if (e.getSource() == internalFuncionario.getBntEditar()) {
				int linha = internalFuncionario.getTabela().getSelectedRow();
				int id = Integer.parseInt(internalFuncionario.getTabela().getValueAt(linha, 0).toString());

				Funcionario funcionario = fachada.buscarFuncionarioPorId(id);
				Endereco endereco = fachada.buscarEnderecoPorId(funcionario.getEndereco_id());
				controllerEditarFuncionario = new ControllerEditarFuncionario(funcionario, endereco);
				internalEditarFuncionario = new InternalEditarFuncionario(telaPrincipal, controllerEditarFuncionario);
				telaPrincipal.getDesktopPane().add(internalEditarFuncionario);
				controllerEditarFuncionario.setInternalEditarFuncionario(internalEditarFuncionario);
				controllerEditarFuncionario.preencherCampos();
				controllerEditarFuncionario.addListeners();
				internalEditarFuncionario.setVisible(true);

			}

			if (e.getSource() == internalFuncionario.getBtnBuscar()) {

				String busca = internalFuncionario.getBuscaField().getText();

				if (busca.equals("")) {
					internalFuncionario.carregarFuncionarios(fachada.listarTodosFuncionarios());

				} else {

					internalFuncionario.carregarFuncionarios(fachada.buscarFuncionarioPorBusca(busca));
				}

			}
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IndexOutOfBoundsException e2) {
			Menssagens.menssagem("SELECIONE UM CAMPO DA TABELA PARA EDITAR.", 0);
		}

	}

	public InternalFuncionario getInternalFuncionario() {
		return internalFuncionario;
	}

	public void setInternalFuncionario(InternalFuncionario internalFuncionario) {
		this.internalFuncionario = internalFuncionario;

	}

	public InternalCadastroFuncionario getInternalCadastroFuncionario() {
		return internalCadastroFuncionario;
	}

	public TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	@Override
	public void addListeners() {
		internalFuncionario.getBntNovo().addActionListener(this);
		internalFuncionario.getBntEditar().addActionListener(this);
		internalFuncionario.getBtnBuscar().addActionListener(this);
	}

}
