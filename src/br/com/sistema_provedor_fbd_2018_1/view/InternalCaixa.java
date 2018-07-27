package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalCaixa extends TelaInternal{
	private Botao btnNovo, btnEditar, btnRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JLabel lblBuscar;
	private JTextField buscarField;
	private Botao btnBuscar;
	public InternalCaixa(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Caixa", telaPrincipal, actionListener);
		setBounds(150, 20, 1050, 610);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar() throws BusinessException {
		btnEditar = new Botao("resource/imagens/botoes/editar-caixa.png","Editar caixa");
		btnEditar.setBounds(50, 20, 210, 40);
		getContentPane().add(btnEditar);

		btnNovo = new Botao("resource/imagens/botoes/adicionar-caixa.png","Nova caixa");
		btnNovo.setBounds(290, 20, 201, 40);
		getContentPane().add(btnNovo);

		btnRemover = new Botao("resource/imagens/botoes/remover-caixa.png","Remover caixa");
		btnRemover.setBounds(520, 20, 230, 40);
		getContentPane().add(btnRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Cidade");
		modelTable.addColumn("Latitude");
		modelTable.addColumn("Longitude");
		

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(47,191,926,379);

		getContentPane().add(barraRolagem);
		
		lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(50, 71, 46, 14);
		getContentPane().add(lblBuscar);
		
		buscarField = new JTextField();
		buscarField.setBounds(50, 102, 200, 28);
		getContentPane().add(buscarField);
		buscarField.setColumns(10);
		
		btnBuscar = new Botao("", "Buscar");
		btnBuscar.setBounds(50, 140, 107, 40);
		getContentPane().add(btnBuscar);
	}

	public void carregarcaixa(List<Caixa> caixas) throws BusinessException {
		modelTable.setNumRows(0);
		for (Caixa caixa : caixas) {
			Cidade cidade = new Fachada().buscarCidadePorId(caixa.getCidade_id());
			String[] linha = {caixa.getId().toString(), caixa.getNome(), cidade.getNome(), caixa.getLatitude(), caixa.getLongitude()};
			modelTable.addRow(linha);
		}

	}

	public Botao getBtnNovo() {
		return btnNovo;
	}

	public Botao getBtnEditar() {
		return btnEditar;
	}

	public Botao getBtnRemover() {
		return btnRemover;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}

	public JTable getTabela() {
		return tabela;
	}

	public JTextField getBuscarField() {
		return buscarField;
	}

	public Botao getBtnBuscar() {
		return btnBuscar;
	}
	



}
