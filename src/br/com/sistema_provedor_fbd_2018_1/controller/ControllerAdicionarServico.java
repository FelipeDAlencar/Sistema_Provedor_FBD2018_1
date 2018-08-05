package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.swing.JPanel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerAdicionarServico implements Listeners, ItemListener {
	private Cliente cliente;
	private InternalAdicionarServico internalAdicionarServico;
	private InternalVerCliente internalVerCliente;
	private List<ServicoCliente> servicos;
	private IFachada fachada;

	public ControllerAdicionarServico(InternalVerCliente internalVerCliente, Cliente cliente) {
		servicos = new ArrayList<>();
		fachada = new Fachada();
		this.cliente = cliente;
		this.internalVerCliente = internalVerCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == internalAdicionarServico.getEnderecoCheckBox()) {
				AutoPreencher();
			}
			if (e.getSource() == internalAdicionarServico.getBtnSalvar()) {
				int endereco_id;
				if (internalAdicionarServico.getEnderecoCheckBox().isSelected()) {
					endereco_id = cliente.getEndereco_id();
				} else {
					Endereco endereco = new Endereco(internalAdicionarServico.getBairroField().getText(),
							internalAdicionarServico.getComplementoField().getText(),
							internalAdicionarServico.getRuaField().getText(),
							Integer.parseInt(internalAdicionarServico.getNumeroField().getText()));

					String cidadeString = (String) internalAdicionarServico.getCidadesComboBox().getSelectedItem();

					String nomeCidade = Ultil.separarString(cidadeString.trim(), 0);
					String estado = Ultil.separarString(cidadeString.trim(), 1);
					Cidade cidade = fachada.buscarPorNomeEstado(nomeCidade, estado);

					endereco_id = 0;

				}

				Servico servico = fachada.buscarServicoNome(
						String.valueOf(internalAdicionarServico.getServicosComboBox().getSelectedItem()));
				Switch sw = fachada.buscarSwitchPorNome(
						String.valueOf(internalAdicionarServico.getSwitchComboBox().getSelectedItem()));
				Porta porta = fachada.buscarPortaPorSwitchNumero(sw.getId(), Integer
						.parseInt(String.valueOf(internalAdicionarServico.getPortaComboBox().getSelectedItem())));
				
				ServicoCliente servicoCliente = new ServicoCliente(servico.getId(), sw.getId(), porta.getId(), endereco_id,cliente.getId());

				fachada.salvarOuEditarServicoCliente(servicoCliente);
				servicos = fachada.buscarServicosPorCliente(cliente.getId());
				internalVerCliente.getPanelServico().carregarServicos(servicos);
				Menssagens.menssagem("Serviço Inserido com sucesso.", 1);

			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	public void AutoPreencher() {
		if (internalAdicionarServico.getEnderecoCheckBox().isSelected()) {
			internalAdicionarServico.getBairroField().setText(internalVerCliente.getBairroField().getText());
			internalAdicionarServico.getRuaField().setText(internalVerCliente.getRuaField().getText());
			internalAdicionarServico.getComplementoField().setText(internalVerCliente.getComplementoField().getText());
			internalAdicionarServico.getNumeroField().setText(internalVerCliente.getNumeroField().getText());
			internalAdicionarServico.getCidadesComboBox()
					.setSelectedIndex(internalVerCliente.getCidadesComboBox().getSelectedIndex());
		} else {
			internalAdicionarServico.getBairroField().setText("");
			internalAdicionarServico.getRuaField().setText("");
			internalAdicionarServico.getComplementoField().setText("");
			internalAdicionarServico.getNumeroField().setText("");
			internalAdicionarServico.getCidadesComboBox().setSelectedIndex(0);

		}

	}

	@Override
	public void addListeners() {
		internalAdicionarServico.getEnderecoCheckBox().addActionListener(this);
		internalAdicionarServico.getBtnSalvar().addActionListener(this);
	}

	public void setInternalAdicionarServico(InternalAdicionarServico internalAdicionarServico) {
		this.internalAdicionarServico = internalAdicionarServico;

	}

}
