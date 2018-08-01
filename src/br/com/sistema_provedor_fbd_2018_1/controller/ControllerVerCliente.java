package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContrato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerVerCliente implements Listeners {
	private InternalVerCliente internalVerCliente;
	private TelaPrincipal telaPrincipal;
	private ControllerAdicionarServico controllerAdicionarServico;
	private InternalAdicionarServico internalAdicionarServico;
	private InternalCadastroContrato internalCadastroContrato;
	private ControllerCadastroContrato controllerCadastroContrato;
	private Fachada fachada;
	private Cliente cliente;

	public ControllerVerCliente( TelaPrincipal telaPrincipal, Cliente cliente) {
		fachada = new Fachada();
		this.cliente = cliente;
		this.telaPrincipal = telaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internalVerCliente.getPanelServico().getBntAdicionar()) {
				controllerAdicionarServico = new ControllerAdicionarServico(internalVerCliente, cliente);
				internalAdicionarServico = new InternalAdicionarServico(telaPrincipal, controllerAdicionarServico);
				telaPrincipal.getDesktopPane().add(internalAdicionarServico);
				internalAdicionarServico.setVisible(true);
				controllerAdicionarServico.setInternalAdicionarServico(internalAdicionarServico);
				controllerAdicionarServico.addListeners();
				
			}
			if(e.getSource() == internalVerCliente.getFinanceiro().getBtnNovoContrato()) {
				controllerCadastroContrato	= new ControllerCadastroContrato(cliente);
				internalCadastroContrato = new InternalCadastroContrato(telaPrincipal, controllerCadastroContrato);
				telaPrincipal.getDesktopPane().add(internalCadastroContrato);
				internalCadastroContrato.setVisible(true);
				controllerCadastroContrato.setInternal(internalCadastroContrato);
				controllerCadastroContrato.addListeners();
			}

		} catch (BusinessException e1) {
			e1.printStackTrace();
		}


	}

	public void carregarDados() {
	
			try {
				Endereco endereco =  fachada.buscarEnderecoPorId(cliente.getEndereco_id());
				internalVerCliente.getNomeField().setText(cliente.getNome());
				internalVerCliente.getCpfField().setText(cliente.getCpf());
				internalVerCliente.getRgField().setText(cliente.getRg());
				internalVerCliente.getDataNascimentoField().setText(cliente.getData_nascimento());
				
				
				internalVerCliente.getBairroField().setText(endereco.getBairro());
				internalVerCliente.getComplementoField().setText(endereco.getComplemento());
				internalVerCliente.getBairroLabel().setText(endereco.getBairro());
				internalVerCliente.getRuaField().setText(endereco.getRua());
				internalVerCliente.getNumeroField().setText(String.valueOf(endereco.getNumero()));
				
				
				
				Cidade cidade = fachada.buscarCidadePorId(endereco.getCidade_id());
				
				internalVerCliente.getCidadesComboBox().setSelectedItem(cidade.getNome() + " - " + cidade.getEstado());
				
				
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void addListeners() {
		internalVerCliente.getPanelServico().getBntAdicionar().addActionListener(this);
		internalVerCliente.getFinanceiro().getBtnNovoContrato().addActionListener(this);
	}

	public InternalVerCliente getInternalVerCliente() {
		return internalVerCliente;
	}

	public void setInternalVerCliente(InternalVerCliente internalVerCliente) {
		this.internalVerCliente = internalVerCliente;
	}



}
