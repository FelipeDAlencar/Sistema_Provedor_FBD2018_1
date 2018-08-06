package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContrato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerVerCliente implements Listeners {
	private InternalVerCliente internalVerCliente;
	private TelaPrincipal telaPrincipal;
	private ControllerAdicionarServico controllerAdicionarServico;
	private InternalAdicionarServico internalAdicionarServico;
	private InternalCadastroContrato internalCadastroContrato;
	private ControllerCadastroContrato controllerCadastroContrato;
	private IFachada fachada;
	private Cliente cliente;
	private ControllerCadastroContato controllerCadastroContato;
	private InternalCadastroContato internalCadastroContato;
	private ControllerEditarContato controllerEditarContato;
	private InternalEditarContato internalEditarContato;
	
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
			
			if (e.getSource() == internalVerCliente.getPanelContatos().getBntAdicionar()) {
				controllerCadastroContato = new ControllerCadastroContato(internalVerCliente, cliente);
				internalCadastroContato = new InternalCadastroContato(telaPrincipal, controllerCadastroContato);
				telaPrincipal.getDesktopPane().add(internalCadastroContato);
				internalCadastroContato.setVisible(true);
				controllerCadastroContato.setInternalCadastroContato(internalCadastroContato);
				controllerCadastroContato.addListeners();
			}
			
			if (e.getSource() == internalVerCliente.getPanelContatos().getBntEditar()) {
				int linha = internalVerCliente.getPanelContatos().getTabela().getSelectedRow();
				String col =  internalVerCliente.getPanelContatos().getModelTable().getValueAt(linha, 1).toString();
				
				Contato contato = fachada.buscarContatoPorContato(col);
				
				controllerEditarContato = new ControllerEditarContato(internalVerCliente,contato, cliente);
				internalEditarContato = new InternalEditarContato(telaPrincipal, controllerEditarContato);
				telaPrincipal.getDesktopPane().add(internalEditarContato);
				controllerEditarContato.setInternalEditarContato(internalEditarContato);
				controllerEditarContato.PreencerCampos();
				internalEditarContato.setVisible(true);
				controllerEditarContato.addListeners();
				
				
			}
			
			if(e.getSource() == internalVerCliente.getFinanceiroPanel().getBtnNovoContrato()) {
				controllerCadastroContrato	= new ControllerCadastroContrato(internalVerCliente, cliente);
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
				
				List<Contato> contatos = fachada.buscarContatoPorCliente(cliente.getId());
				internalVerCliente.getPanelContatos().carregarContatos(contatos);
				
				List<ServicoCliente> servicos = fachada.buscarServicosPorCliente(cliente.getId());
				internalVerCliente.getPanelServico().carregarServicos(servicos);
				
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void addListeners() {
		internalVerCliente.getPanelServico().getBntAdicionar().addActionListener(this);
		internalVerCliente.getFinanceiroPanel().getBtnNovoContrato().addActionListener(this);
		internalVerCliente.getPanelContatos().getBntAdicionar().addActionListener(this);
		internalVerCliente.getPanelContatos().getBntEditar().addActionListener(this);
		
	}

	public InternalVerCliente getInternalVerCliente() {
		return internalVerCliente;
	}

	public void setInternalVerCliente(InternalVerCliente internalVerCliente) {
		this.internalVerCliente = internalVerCliente;
	}



}
