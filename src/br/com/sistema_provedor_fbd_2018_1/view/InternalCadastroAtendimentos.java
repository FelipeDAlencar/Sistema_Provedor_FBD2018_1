package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class InternalCadastroAtendimentos extends TelaInternal {
	private JTextField motivoField;
	private Botao btnSalvar;
	private JLabel lblDataDeAtendimento;
	private JtextFieldGenerico dataField;
	private JComboBox<String> servicosCombo;

	public InternalCadastroAtendimentos(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Inserir Atendimento", telaPrincipal, actionListener);
		setBounds(480, 150, 465, 296);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {

		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(40, 91, 46, 14);
		getContentPane().add(lblMotivo);

		motivoField = new JTextField();
		motivoField.setBounds(40, 121, 358, 30);
		getContentPane().add(motivoField);
		motivoField.setColumns(10);

		btnSalvar = new Botao("", "Salvar");
		btnSalvar.setBounds(295, 187, 103, 40);
		getContentPane().add(btnSalvar);

		lblDataDeAtendimento = new JLabel("Data de atendimento:");
		lblDataDeAtendimento.setBounds(272, 24, 146, 14);
		getContentPane().add(lblDataDeAtendimento);

		dataField = new JtextFieldGenerico("1234567890");
		dataField.setBounds(272, 49, 126, 30);
		getContentPane().add(dataField);
		dataField.setColumns(10);

		try {
			dataField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

			JLabel lblServico = new JLabel("Servico:");
			lblServico.setBounds(40, 24, 46, 14);
			getContentPane().add(lblServico);

			servicosCombo = new JComboBox<>();
			servicosCombo.setBounds(40, 49, 211, 31);
			getContentPane().add(servicosCombo);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void carregarServico(int cliente_id) {
		try {
			IFachada fachada = new Fachada();
			List<ServicoCliente> servicos;
			servicos = fachada.buscarServicosPorCliente(cliente_id);
			for (ServicoCliente servicoCliente : servicos) {
				servicosCombo.addItem(servicoCliente.getDescricao());
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTextField getMotivoField() {
		return motivoField;
	}

	public Botao getBtnSalvar() {
		return btnSalvar;
	}

	public JLabel getLblDataDeAtendimento() {
		return lblDataDeAtendimento;
	}

	public JtextFieldGenerico getDataField() {
		return dataField;
	}

	public JComboBox<String> getServicosCombo() {
		return servicosCombo;
	}
}
