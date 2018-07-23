package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAdicionarCliente;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCliente implements Listeners, ItemListener {
	private InternalAdicionarCliente adicionarCliente;
	private Fachada fachada;

	public ControllerCliente(InternalAdicionarCliente internalAdicionarCliente) {
		fachada = new Fachada();
	}

	public ControllerCliente() {
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Contato> contatos = new ArrayList<>();

		if (e.getSource() == adicionarCliente.getBtnSalvar()) {
			try {
				if (contatos.isEmpty() == false) {

					br.com.sistema_provedor_fbd_2018_1.entidade.Cliente cliente = new br.com.sistema_provedor_fbd_2018_1.entidade.Cliente(
							adicionarCliente.getNomeField().getText(), adicionarCliente.getCpfField().getText(),
							adicionarCliente.getRgField().getText(),
							adicionarCliente.getDataNascimentoField().getText());

					Endereco endereco = new Endereco(adicionarCliente.getBairroField().getText(),
							adicionarCliente.getComplementoField().getText(), adicionarCliente.getRuaField().getText(),
							Integer.parseInt(adicionarCliente.getNumeroField().getText()));

					adicionarCliente.getNomeField().setText("");
					adicionarCliente.getRgField().setText("");
					adicionarCliente.getDataNascimentoField().setText("");
					adicionarCliente.getComplementoField().setText("");
					adicionarCliente.getBairroField().setText("");
					adicionarCliente.getRuaField().setText("");
					adicionarCliente.getNumeroField().setText("");

					

					fachada.salvarOuEditarEndereco(endereco);
					fachada.salvarOuEditarCliente(cliente);
					
					Menssagens.menssagem("Cliente Adicionado com sucesso.", 1);
				}else {
					throw new BusinessException("O CLIENTE DEVE TER PELO MENOS UM CONTATO.");
				}
			} catch (BusinessException e1) {
				e1.printStackTrace();;
			}

		}
		if(e.getSource() == adicionarCliente.getBtnNovoContato()) {
			Contato contato = new Contato("",(String)adicionarCliente.getComboContato().getSelectedItem(),
					adicionarCliente.getContatoField().getText());
			contatos.add(contato);
		}
		
		
		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (adicionarCliente.getComboContato().getSelectedIndex() == 2
				|| adicionarCliente.getComboContato().getSelectedIndex() == 3) {
			try {
				adicionarCliente.getContatoField()
						.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(###)#####-####")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			adicionarCliente.getContatoField().setFormatterFactory(null);
			adicionarCliente.getContatoField().setText("");

		}

		adicionarCliente.getLblTipo().setVisible(true);
		adicionarCliente.getContatoField().setVisible(true);

		String op = (String) adicionarCliente.getComboContato().getSelectedItem();
		if (!op.equals("")) {
			adicionarCliente.getLblTipo().setText(op + ":");
		}

		adicionarCliente.getBtnNovoContato().setVisible(true);

	}

	public InternalAdicionarCliente getAdicionarCliente() {
		return adicionarCliente;
	}

	public void setAdicionarCliente(InternalAdicionarCliente adicionarCliente) {
		this.adicionarCliente = adicionarCliente;
	}

	@Override
	public void addListeners() {
		adicionarCliente.getBtnSalvar().addActionListener(this);
		adicionarCliente.getComboContato().addItemListener(this);
		adicionarCliente.getBtnNovoContato().addActionListener(this);

	}

}
