package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumAtendimento;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumParcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContrato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarContato;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalVerCliente;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerVerCliente implements Listeners{
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
	private ControllerEditarServicoCliente controllerEditarServicoCliente;
	private InternalEditarServicoCliente internalEditarServicoCliente;
	private ControllerCadastroAtendimento controllerCadastroAtendimento;
	private InternalCadastroAtendimentos internalAdicionarAtendimento;

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

			if (e.getSource() == internalVerCliente.getPanelServico().getBntEditar()) {
				int linha = internalVerCliente.getPanelServico().getTabela().getSelectedRow();
				int id = Integer.parseInt(internalVerCliente.getPanelServico().getModelTable().getValueAt(linha, 0).toString());

				ServicoCliente servico = fachada.buscarServicosClientesPorId(id);

				controllerEditarServicoCliente= new ControllerEditarServicoCliente(servico);
				internalEditarServicoCliente = new InternalEditarServicoCliente(telaPrincipal, controllerEditarServicoCliente);
				telaPrincipal.getDesktopPane().add(internalEditarServicoCliente);
				controllerEditarServicoCliente.setInternalEditarServicoCliente(internalEditarServicoCliente);
				controllerEditarServicoCliente.preencherCampos();
				controllerEditarServicoCliente.addListeners();
				internalEditarServicoCliente.setVisible(true);
			}

			if (e.getSource() == internalVerCliente.getPanelContatos().getBntAdicionar()) {
				controllerCadastroContato = new ControllerCadastroContato(internalVerCliente, cliente);
				internalCadastroContato = new InternalCadastroContato(telaPrincipal, controllerCadastroContato);
				telaPrincipal.getDesktopPane().add(internalCadastroContato);
				controllerCadastroContato.setInternalCadastroContato(internalCadastroContato);
				controllerCadastroContato.addListeners();
				internalCadastroContato.setVisible(true);
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

			if(e.getSource() == internalVerCliente.getPanelFinanceiro().getBtnNovoContrato()) {
				controllerCadastroContrato	= new ControllerCadastroContrato(internalVerCliente, cliente);
				internalCadastroContrato = new InternalCadastroContrato(telaPrincipal, controllerCadastroContrato);
				telaPrincipal.getDesktopPane().add(internalCadastroContrato);
				internalCadastroContrato.carregarServicos(cliente.getId());
				controllerCadastroContrato.setInternal(internalCadastroContrato);
				controllerCadastroContrato.addListeners();
				internalCadastroContrato.setVisible(true);
			}
			
			if(e.getSource() == internalVerCliente.getPanelAtendimento().getBntAdicionar()) {
				controllerCadastroAtendimento = new ControllerCadastroAtendimento(cliente, internalVerCliente);
				internalAdicionarAtendimento = new InternalCadastroAtendimentos(telaPrincipal, controllerCadastroAtendimento);
				telaPrincipal.getDesktopPane().add(internalAdicionarAtendimento);
				controllerCadastroAtendimento.setInternal(internalAdicionarAtendimento);
				controllerCadastroAtendimento.addListeners();
				internalAdicionarAtendimento.carregarServico(cliente.getId());
				internalAdicionarAtendimento.setVisible(true);
				
			}
			
			if (e.getSource() == internalVerCliente.getPanelAtendimento().getBntConcluir()) {
				int linha = internalVerCliente.getPanelAtendimento().getTabela().getSelectedRow();
				int id = Integer.parseInt(internalVerCliente.getPanelAtendimento().getModelTable().getValueAt(linha,0).toString());
				Atendimento atendimento = fachada.buscarAtendimentoPorId(id);
				atendimento.setStatus(enumAtendimento.CONCLUIDO);
				fachada.salvarOuEditarAtendimento(atendimento);
				List<Atendimento> atendimentos = fachada.buscarAtendimentoPorCliente(cliente.getId());
				internalVerCliente.getPanelAtendimento().carregarAtendimento(atendimentos);
			}
			
			if (e.getSource() == internalVerCliente.getPanelAtendimento().getBntCancelar()) {
				int linha = internalVerCliente.getPanelAtendimento().getTabela().getSelectedRow();
				int id = Integer.parseInt(internalVerCliente.getPanelAtendimento().getModelTable().getValueAt(linha,0).toString());
				Atendimento atendimento = fachada.buscarAtendimentoPorId(id);
				atendimento.setStatus(enumAtendimento.CANCELADO);
				fachada.salvarOuEditarAtendimento(atendimento);
				List<Atendimento> atendimentos = fachada.buscarAtendimentoPorCliente(cliente.getId());
				internalVerCliente.getPanelAtendimento().carregarAtendimento(atendimentos);
			}
	
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}


	}

	public void carregarDados() {

		try {
			Calendar calendar = Ultil.pegarDataParaEdicao(cliente.getData_nascimento());
			Endereco endereco =  fachada.buscarEnderecoPorId(cliente.getEndereco_id());
			internalVerCliente.getNomeField().setText(cliente.getNome());
			internalVerCliente.getCpfField().setText(cliente.getCpf());
			internalVerCliente.getRgField().setText(cliente.getRg());
			internalVerCliente.getDataNascimentoField().setCalendar(calendar);


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
			
			List<Atendimento> atendimentos =fachada.buscarAtendimentoPorCliente(cliente.getId());
			internalVerCliente.getPanelAtendimento().carregarAtendimento(atendimentos);

		} catch (BusinessException e) {

			e.printStackTrace();
		}



	}

	@Override
	public void addListeners(){
		internalVerCliente.getPanelServico().getBntAdicionar().addActionListener(this);
		internalVerCliente.getPanelServico().getBntEditar().addActionListener(this);
		internalVerCliente.getPanelFinanceiro().getBtnNovoContrato().addActionListener(this);
		internalVerCliente.getPanelContatos().getBntAdicionar().addActionListener(this);
		internalVerCliente.getPanelContatos().getBntEditar().addActionListener(this);
		internalVerCliente.getPanelAtendimento().getBntAdicionar().addActionListener(this);
		internalVerCliente.getPanelAtendimento().getBntConcluir().addActionListener(this);
		internalVerCliente.getPanelAtendimento().getBntCancelar().addActionListener(this);

		for (JTable table : internalVerCliente.getPanelFinanceiro().getTabelas()) {
			System.out.println(table.getName());
			table.addMouseListener(new MouseAdapter() {
				@Override  
				public void mouseClicked(MouseEvent e) { 
					try {
						IFachada fachada = new Fachada();
						JPopupMenu menu = new JPopupMenu();
						JMenuItem baixar = new JMenuItem("Baixar");
						int linha = table.getSelectedRow();
						int id = Integer.parseInt(table.getModel().getValueAt(linha, 0).toString());
						Parcela parcela;

						parcela = fachada.buscarParcelaId(id);

						baixar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								parcela.setStatus(enumParcela.PAGO);
								try {
									fachada.salvarOuEditar(parcela);
								} catch (BusinessException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						JMenuItem cancelar = new JMenuItem("Cancelar");
						cancelar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								parcela.setStatus(enumParcela.CANCELADA);
								try {
									fachada.salvarOuEditar(parcela);
								} catch (BusinessException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});

						JMenuItem sair = new JMenuItem("Sair");
						cancelar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								menu.setVisible(false);
							}
						});
						menu.add(baixar);
						menu.add(cancelar);
						menu.add(sair);
						menu.show(table, e.getX(), e.getY());
						
					} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}


			});

		}

	}

	public InternalVerCliente getInternalVerCliente() {
		return internalVerCliente;
	}

	public void setInternalVerCliente(InternalVerCliente internalVerCliente) {
		this.internalVerCliente = internalVerCliente;
	}



}
