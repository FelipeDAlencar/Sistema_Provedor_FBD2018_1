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
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;

public class ControllerCadastroContato implements Listeners, ItemListener {
	private InternalCadastroContato internalCadastroContato;
	private InternalCadastroCliente internalCadastroCliente;
	private static List<Contato> contatos = new ArrayList<>();
	private Cliente cliente;
	private IFachada fachada;

	public ControllerCadastroContato(InternalCadastroCliente internalCadastroCliente) {
		this.internalCadastroCliente = internalCadastroCliente;
			}
	public ControllerCadastroContato(InternalCadastroCliente internalCadastroCliente, Cliente cliente) {
		this.internalCadastroCliente = internalCadastroCliente;
		this.cliente = cliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroContato.getBtnSalvar()) {
			Contato contato = new Contato(internalCadastroContato.getResponsavelField().getText(),
					(String) internalCadastroContato.getComboContato().getSelectedItem(),
					internalCadastroContato.getContatoField().getText());
			
			internalCadastroContato.getResponsavelField().setText("");
			internalCadastroContato.getContatoField().setText("");
			if(cliente==null) {
				contatos.add(contato);
			}else {
				try {
					fachada = new Fachada();
					fachada.salvarOuEditarContato(contato, cliente.getCpf());
					contatos = fachada.buscarContatoPorCliente(cliente.getId());
				} catch (BusinessException e1) {
					e1.printStackTrace();
				}			
			}
			internalCadastroCliente.getPanelContatos().carregarContatos(contatos);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (internalCadastroContato.getComboContato().getSelectedIndex() == 2
				|| internalCadastroContato.getComboContato().getSelectedIndex() == 3) {
			try {
				internalCadastroContato.getContatoField()
						.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(###)#####-####")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			internalCadastroContato.getContatoField().setFormatterFactory(null);
			internalCadastroContato.getContatoField().setText("");

		}

		internalCadastroContato.getLblTipo().setVisible(true);
		internalCadastroContato.getContatoField().setVisible(true);

		String op = (String) internalCadastroContato.getComboContato().getSelectedItem();
		if (!op.equals("")) {
			internalCadastroContato.getLblTipo().setText(op + ":");
		}

		internalCadastroContato.getBtnSalvar().setVisible(true);
		internalCadastroContato.getResponsavelField().setVisible(true);
		internalCadastroContato.getLblResponsvel().setVisible(true);

	}

	@Override
	public void addListeners() {
		internalCadastroContato.getBtnSalvar().addActionListener(this);
		internalCadastroContato.getComboContato().addItemListener(this);

	}

	public InternalCadastroContato getInternalCadastroContato() {
		return internalCadastroContato;
	}

	public void setInternalCadastroContato(InternalCadastroContato internalCadastroContato) {
		this.internalCadastroContato = internalCadastroContato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		ControllerCadastroContato.contatos = contatos;
	}
	

}
