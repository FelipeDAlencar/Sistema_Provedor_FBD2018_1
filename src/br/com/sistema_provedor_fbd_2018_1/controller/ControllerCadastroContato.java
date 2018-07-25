package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCliente;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroContato;
import br.com.sistema_provedor_fbd_2018_1.view.PanelContato;

public class ControllerCadastroContato implements Listeners, ItemListener {
	private InternalCadastroContato internalCadastroContato;
	private InternalCadastroCliente internalCadastroCliente;
	private static ArrayList<Contato> contatos = new ArrayList<>();

	public ControllerCadastroContato(InternalCadastroCliente internalCadastroCliente) {
		this.internalCadastroCliente = internalCadastroCliente;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroContato.getBtnSalvar()) {
			Contato contato = new Contato(internalCadastroContato.getResponsavelField().getText(),
					(String) internalCadastroContato.getComboContato().getSelectedItem(),
					internalCadastroContato.getContatoField().getText());
			contatos.add(contato);
			internalCadastroContato.getResponsavelField().setText("");
			internalCadastroContato.getContatoField().setText("");
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

	public ArrayList<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
	

}
