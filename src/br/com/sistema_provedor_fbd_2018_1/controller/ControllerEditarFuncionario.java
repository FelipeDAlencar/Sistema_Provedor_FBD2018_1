package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.Calendar;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarFuncionario;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarFuncionario implements Listeners {
	private InternalEditarFuncionario internalEditarFuncionario;
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
		if (e.getSource() == internalEditarFuncionario.getBtnAdicionar()) {

			try {
				Funcionario funcionario = new Funcionario(this.funcionario.getId(), internalEditarFuncionario.getNomeFild().getText(), 
						internalEditarFuncionario.getCargoField().getText(), Ultil.converterJavaDateEmString(internalEditarFuncionario.getData_contratoFild().getDate()), internalEditarFuncionario.getLoginFild().getText(), 
						new String(internalEditarFuncionario.getSenhaField().getPassword()), this.endereco.getId());

				String NomeEstado = (String)internalEditarFuncionario.getCidadesCombo().getSelectedItem();
				
				String nomeCidade = Ultil.separarString(NomeEstado, 0);
				String estado = Ultil.separarString(NomeEstado, 1);
				
				Cidade cidade = fachada.buscarPorNomeEstado(nomeCidade, estado);
				
				
				
				Endereco endereco = new Endereco(
						this.funcionario.getEndereco_id(),
						internalEditarFuncionario.getBairroFild().getText(),
						internalEditarFuncionario.getComplementoFild().getText(),
						internalEditarFuncionario.getRuaFild().getText(),
						Integer.parseInt(internalEditarFuncionario.getNumeroFild().getText()),
						cidade.getId());

				fachada.salvarOuEditarEndereco(endereco);
				fachada.salvarOuEditarFuncionario(funcionario, endereco);

				Menssagens.menssagem("Funcionário Editado com sucesso!", 1);


			} catch (BusinessException e1) {
				e1.getMessage();
			}
		}

	}

	public void preencherCampos() {
		Calendar calendar = Ultil.pegarDataParaEdicao(funcionario.getData_contrato());
		System.out.println(internalEditarFuncionario);
		internalEditarFuncionario.getBairroFild().setText(endereco.getBairro());
		internalEditarFuncionario.getNumeroFild().setText(String.valueOf(endereco.getNumero()));
		internalEditarFuncionario.getRuaFild().setText(endereco.getRua());
		internalEditarFuncionario.getComplementoFild().setText(endereco.getComplemento());
		internalEditarFuncionario.getCargoField().setText(funcionario.getCargo());
		internalEditarFuncionario.getLoginFild().setText(funcionario.getLogin());
		internalEditarFuncionario.getSenhaField().setText(funcionario.getSenha());
		internalEditarFuncionario.getNomeFild().setText(funcionario.getNome());
		internalEditarFuncionario.getData_contratoFild().setCalendar(calendar);

	}

	@Override
	public void addListeners() {
		internalEditarFuncionario.getBtnAdicionar().addActionListener(this);

	}

	public InternalEditarFuncionario getInternalEditarFuncionario() {
		return internalEditarFuncionario;
	}

	public void setInternalEditarFuncionario(InternalEditarFuncionario internalEditarFuncionario) {
		this.internalEditarFuncionario = internalEditarFuncionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
