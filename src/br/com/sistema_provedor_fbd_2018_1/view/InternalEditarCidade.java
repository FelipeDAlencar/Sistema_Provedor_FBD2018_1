package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InternalEditarCidade extends InternalCadastroCidade {
	private JComboBox<String> comboIDCidade;
	private Fachada fachada;

	public InternalEditarCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super(telaPrincipal, actionListener);
		getCepField().setLocation(589, 93);
		fachada = new Fachada();
		JLabel label = new JLabel("");
		label.setBounds(52, 153, 46, 14);
		getContentPane().add(label);

		JLabel lblIdDaCidade = new JLabel("ID da cidade:");
		lblIdDaCidade.setBounds(52, 165, 78, 14);
		getContentPane().add(lblIdDaCidade);
		
		getBtnAdd().setText("Editar Cidade");
		carregarIDCidades();
		comboIDCidade.setBounds(52, 190, 218, 30);
		getContentPane().add(comboIDCidade);

	}
	public void carregarIDCidades() throws BusinessException {
		ArrayList<Cidade> cidades = fachada.listarTodosCidades();
		comboIDCidade = new JComboBox<>();
		comboIDCidade.addItem("");
		for (Cidade cidade : cidades) {
			comboIDCidade.addItem(String.valueOf(cidade.getId()));
		}
	}
	public JComboBox<String> getComboIDCidade() {
		return comboIDCidade;
	}
	
	
}
