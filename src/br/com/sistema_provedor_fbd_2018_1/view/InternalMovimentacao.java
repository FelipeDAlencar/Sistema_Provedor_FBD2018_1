package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JRadioButton;

public class InternalMovimentacao  extends TelaInternal{
	private Botao btnNovo, btnEditar, btnRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JLabel lblBuscar;
	private JTextField buscarField;
	private Botao btnBuscar;
	private JRadioButton radioPagos,radioNaoPagos;
	private ButtonGroup grupoBtn;
	private ArrayList<JCheckBox> checkBoxs;
	public InternalMovimentacao(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Movimentações", telaPrincipal, actionListener);
		setBounds(150, 20, 1050, 610);
		getContentPane().setLayout(null);
	}

	@Override
	public void inicializar(){	
		btnEditar = new Botao("resource/imagens/botoes/editar-servico.png","Editar Lançamento");
		btnEditar.setBounds(50, 20, 190, 40);
		getContentPane().add(btnEditar);

		btnNovo = new Botao("resource/imagens/botoes/adicionar-servico.png","Novo Lançamento");
		btnNovo.setBounds(250, 20, 177, 40);
		getContentPane().add(btnNovo);

		btnRemover = new Botao("resource/imagens/botoes/remover-servico.png","Remover Laçamento");
		btnRemover.setBounds(437, 20, 200, 40);
		getContentPane().add(btnRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Data");
		modelTable.addColumn("Descrição");
		modelTable.addColumn("Valor");
		modelTable.addColumn("Situação");
		

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,191,928,320);

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
		
		radioPagos = new JRadioButton("Pagos");
		radioPagos.setBounds(291, 105, 109, 23);
		getContentPane().add(radioPagos);
		
		radioNaoPagos = new JRadioButton("N\u00E3o Pagos");
		radioNaoPagos.setBounds(384, 105, 109, 23);
		getContentPane().add(radioNaoPagos);
		
		
		grupoBtn = new ButtonGroup();
		grupoBtn.add(radioNaoPagos);
		grupoBtn.add(radioPagos);;
	}

	public void carregarMovimentacoes(List<Movimentacao> movimentacaos) {
		modelTable.setNumRows(0);
		for (Movimentacao movimentacao : movimentacaos) {
			String[] linha = {movimentacao.getId().toString(), movimentacao.getData_movimentacao(), movimentacao.getDescricao(),
					String.valueOf(movimentacao.getValor()), movimentacao.getSituacao()};
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

	public JRadioButton getRadioPagos() {
		return radioPagos;
	}

	public JRadioButton getRadioNaoPagos() {
		return radioNaoPagos;
	}
	
}
