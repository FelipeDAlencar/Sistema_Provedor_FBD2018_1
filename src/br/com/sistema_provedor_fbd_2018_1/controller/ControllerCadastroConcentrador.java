package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroConcentrador;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.Messagens;

public class ControllerCadastroConcentrador implements Listeners {
	private InternalCadastroConcentrador internalCadastroConcentrador;
	private Fachada fachada;

	public ControllerCadastroConcentrador() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void addListeners() {
		internalCadastroConcentrador.getBtnAdicionar().addActionListener(this);

	}

	public InternalCadastroConcentrador getInternalCadastroConcentrador() {
		return internalCadastroConcentrador;
	}

	public void setInternalCadastroConcentrador(InternalCadastroConcentrador internalCadastroConcentrador) {
		this.internalCadastroConcentrador = internalCadastroConcentrador;
	}

}
