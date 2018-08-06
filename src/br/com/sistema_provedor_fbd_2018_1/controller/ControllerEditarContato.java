package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarContato;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarContato implements Listeners,ItemListener {
	private InternalEditarContato internalEditarContato;
	private InternalCadastroCliente internalCadastroCliente;
	private Contato contato;
	private List<Contato> contatos;
	private Cliente cliente;
	private int linha;

	public ControllerEditarContato(List<Contato> contatos, int linha, InternalCadastroCliente internalCadastroCliente) {
		this.contatos = contatos;
		this.linha = linha;
		contato = contatos.get(linha);
		this.internalCadastroCliente = internalCadastroCliente;

	}

	public ControllerEditarContato(InternalCadastroCliente internalCadastroCliente, Contato contato, Cliente cliente) {
		this.internalCadastroCliente = internalCadastroCliente;
		this.contato = contato;
		this.cliente= cliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == internalEditarContato.getBtnSalvar()) {
			String tipo = (String)internalEditarContato.getComboContato().getSelectedItem();
			Contato contato = new Contato(internalEditarContato.getResponsavelField().getText(), tipo, internalEditarContato.getContatoField().getText());
			
			if (contatos==null) {
				Fachada fachada = new Fachada();
				try {
					contato.setId(this.contato.getId());
					fachada.salvarOuEditarContato(contato, cliente.getCpf());
					contatos = fachada.buscarContatoPorCliente(cliente.getId());
				} catch (BusinessException e1) {
					e1.printStackTrace();
				}
			}else {
				contatos.remove(linha);
				contatos.add(linha, contato);
			}
			internalCadastroCliente.getPanelContatos().carregarContatos(contatos);
			Menssagens.menssagem("Contato editado com sucesso.", 1);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (internalEditarContato.getComboContato().getSelectedIndex() == 2
				|| internalEditarContato.getComboContato().getSelectedIndex() == 3) {
			try {
				internalEditarContato.getContatoField()
				.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(###)#####-####")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			internalEditarContato.getContatoField().setFormatterFactory(null);
			internalEditarContato.getContatoField().setText("");

		}

		internalEditarContato.getLblTipo().setVisible(true);
		internalEditarContato.getContatoField().setVisible(true);

		String op = (String) internalEditarContato.getComboContato().getSelectedItem();
		if (!op.equals("")) {
			internalEditarContato.getLblTipo().setText(op + ":");
		}

		internalEditarContato.getBtnSalvar().setVisible(true);
		internalEditarContato.getResponsavelField().setVisible(true);
		internalEditarContato.getLblResponsvel().setVisible(true);

	}

	@Override
	public void addListeners() {
		internalEditarContato.getBtnSalvar().addActionListener(this);
		internalEditarContato.getComboContato().addItemListener(this);

	}

	public void PreencerCampos() {
		internalEditarContato.getComboContato().setSelectedItem(contato.getTipo());
		internalEditarContato.getContatoField().setText(contato.getContato());
		internalEditarContato.getResponsavelField().setText(contato.getResponsavel());

	}

	public InternalEditarContato getInternalEditarContato() {
		return internalEditarContato;
	}

	public void setInternalEditarContato(InternalEditarContato internalEditarContato) {
		this.internalEditarContato = internalEditarContato;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
