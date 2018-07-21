package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarFuncionario implements Listeners {
	private InternalEditarFuncionario InternalEditarFuncionario;
	private Fachada fachada;
	private Funcionario funcionario;
	private Endereco endereco;

	public ControllerEditarFuncionario(Funcionario funcionario, Endereco endereco) {
		this.funcionario = funcionario;
		this.endereco = endereco;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == InternalEditarFuncionario.getBtnAdicionar()) {

			try {
				Funcionario funcionario = new Funcionario(this.funcionario.getId(),InternalEditarFuncionario.getNomeFild().getText(),
						InternalEditarFuncionario.getCargoField().getText(),
						InternalEditarFuncionario.getData_contratoFild().getText(),
						InternalEditarFuncionario.getLoginFild().getText(),
						new String(InternalEditarFuncionario.getSenhaField().getPassword()), this.endereco.getId());

				Endereco endereco = new Endereco(InternalEditarFuncionario.getBairroFild().getText(),
						InternalEditarFuncionario.getComplementoFild().getText(),
						InternalEditarFuncionario.getRuaFild().getText(),
						Integer.parseInt(InternalEditarFuncionario.getNumeroFild().getText()));

				fachada.salvarOuEditarEndereco(endereco);
				fachada.salvarOuEditarFuncionario(funcionario);

				Menssagens.menssagem("Funcionário Editado com sucesso!", 1);

				InternalEditarFuncionario.getNomeFild().setText("");
				InternalEditarFuncionario.getCargoField().setText("");
				InternalEditarFuncionario.getData_contratoFild().setText("");
				InternalEditarFuncionario.getLoginFild().setText("");
				InternalEditarFuncionario.getSenhaField().setText("");
				InternalEditarFuncionario.getBairroFild().setText("");
				InternalEditarFuncionario.getRuaFild().setText("");
				InternalEditarFuncionario.getNumeroFild().setText("");

			} catch (BusinessException e1) {
				e1.getMessage();
			}
		}

	}

	public void preencherCampos() {
		InternalEditarFuncionario.getBairroFild().setText(endereco.getBairro());
		InternalEditarFuncionario.getNumeroFild().setText(String.valueOf(endereco.getNumero()));
		InternalEditarFuncionario.getRuaFild().setText(endereco.getRua());
		InternalEditarFuncionario.getComplementoFild().setText(endereco.getComplemento());
		InternalEditarFuncionario.getCargoField().setText(funcionario.getCargo());
		InternalEditarFuncionario.getLoginFild().setText(funcionario.getLogin());
		InternalEditarFuncionario.getSenhaField().setText(funcionario.getSenha());
		InternalEditarFuncionario.getNomeFild().setText(funcionario.getNome());
		InternalEditarFuncionario.getData_contratoFild().setText(funcionario.getData_contrato());

	}

	@Override
	public void addListeners() {
		InternalEditarFuncionario.getBtnAdicionar().addActionListener(this);

	}

	public InternalEditarFuncionario getInternalEditarFuncionario() {
		return InternalEditarFuncionario;
	}

	public void setInternalEditarFuncionario(InternalEditarFuncionario internalEditarFuncionario) {
		InternalEditarFuncionario = internalEditarFuncionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
