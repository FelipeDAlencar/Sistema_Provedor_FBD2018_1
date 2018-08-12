package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalConcentrador extends TelaInternal{
	private Botao btnNovo, btnEditar, btnRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private Fachada fachada;
	private JLabel lblBuscar;
	private JTextField buscarField;
	private Botao btnBuscar;
	public InternalConcentrador(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Concentrador", telaPrincipal, actionListener);
		setBounds(150, 20, 1050, 610);
		getContentPane().setLayout(null);
		fachada = new Fachada();
	}

	@Override
	public void inicializar() throws BusinessException {
		btnEditar = new Botao("resource/imagens/botoes/editar-concentrador.png","Editar Concentrador");
		btnEditar.setBounds(50, 20, 210, 40);
		getContentPane().add(btnEditar);

		btnNovo = new Botao("resource/imagens/botoes/adicionar-concentrador.png","Nova Concentrador");
		btnNovo.setBounds(290, 20, 201, 40);
		getContentPane().add(btnNovo);

		btnRemover = new Botao("resource/imagens/botoes/remover-concentrador.png","Remover Concentrador");
		btnRemover.setBounds(520, 20, 230, 40);
		getContentPane().add(btnRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("IP");
		modelTable.addColumn("CIDADE");

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,197,926,361);

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

	public void carregarConcentrador(List<Concentrador> concentradores) {
		modelTable.setNumRows(0);
		try {for (Concentrador concentrador : concentradores) {
			Cidade cidade = fachada.buscarCidadePorId(concentrador.getCidade_id());
			String[] linha = {concentrador.getId().toString(), concentrador.getNome(), concentrador.getIp(), cidade.getNome()};
			modelTable.addRow(linha);

		}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	public Botao getBtnNovo() {
		return btnNovo;
	}

	public void setBtnNovo(Botao btnNovo) {
		this.btnNovo = btnNovo;
	}

	public Botao getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(Botao btnEditar) {
		this.btnEditar = btnEditar;
	}

	public Botao getBtnRemover() {
		return btnRemover;
	}

	public void setBtnRemover(Botao btnRemover) {
		this.btnRemover = btnRemover;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}

	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}

	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTextField getBuscarField() {
		return buscarField;
	}

	public Botao getBtnBuscar() {
		return btnBuscar;
	}


}
