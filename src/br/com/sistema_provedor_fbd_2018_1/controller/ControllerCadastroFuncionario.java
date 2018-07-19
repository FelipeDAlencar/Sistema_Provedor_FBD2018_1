package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.Messagens;

public class ControllerCadastroFuncionario implements Listeners {
	private InternalCadastroFuncionario internalCadastroFuncionario;
	private Fachada fachada;

	public ControllerCadastroFuncionario() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroFuncionario.getBtnAdicionar()) {
			Funcionario funcionario = new Funcionario(internalCadastroFuncionario.getNomeFild().getText(),
					internalCadastroFuncionario.getCargoField().getText(),
					internalCadastroFuncionario.getData_contratoFild().getText(),
					internalCadastroFuncionario.getLoginFild().getText(),
					new String(internalCadastroFuncionario.getSenhaField().getPassword()));
			

			Endereco endereco = new Endereco(internalCadastroFuncionario.getBairroFild().getText(),
					internalCadastroFuncionario.getComplementoFild().getText(),
					internalCadastroFuncionario.getRuaFild().getText(),
					Integer.parseInt(internalCadastroFuncionario.getNumeroFild().getText()));
			
			
			Messagens.messagem("Funcionário salvo com sucesso!", 1);
			
			internalCadastroFuncionario.getNomeFild().setText("");
			internalCadastroFuncionario.getCargoField().setText("");
			internalCadastroFuncionario.getData_contratoFild().setText("");
			internalCadastroFuncionario.getLoginFild().setText("");
			internalCadastroFuncionario.getSenhaField().setText("");
			internalCadastroFuncionario.getBairroFild().setText("");
			internalCadastroFuncionario.getRuaFild().setText("");
			internalCadastroFuncionario.getNumeroFild().setText("");
			
			try {
				fachada.salvarOuEditarEndereco(endereco);
				fachada.salvarOuEditarFuncionario(funcionario);

			} catch (BusinessException e1) {
				e1.printStackTrace();
			}

		}

	}

	@Override
	public void addListeners() {
		internalCadastroFuncionario.getBtnAdicionar().addActionListener(this);

	}

	public InternalCadastroFuncionario getInternalCadastroFuncionario() {
		return internalCadastroFuncionario;
	}

	public void setInternalCadastroFuncionario(InternalCadastroFuncionario internalCadastroFuncionario) {
		this.internalCadastroFuncionario = internalCadastroFuncionario;
	}

}
