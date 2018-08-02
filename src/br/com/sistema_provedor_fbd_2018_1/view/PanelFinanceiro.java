package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PanelFinanceiro extends JPanel {
	private Botao btnNovoContrato;
	private DefaultTableModel modelTable;
	// private JScrollPane barraRolagem, barra2, barraGeral;
	// private JTable tabela, tabela2;

	public PanelFinanceiro() {
		setLayout(null);
		btnNovoContrato = new Botao("", "Novo Contrato");
		btnNovoContrato.setBounds(50, 10, 159, 40);
		add(btnNovoContrato);

	}

	public void carregarTabelas(ArrayList<Contrato> contratos) {
		try {
			int largura = 773;
			int altura = 180;
			int x = 50, y = 80;

			JTable tabela = new JTable(modelTable);
			ArrayList<JScrollPane> scrollPanes = new ArrayList<>();
			JScrollPane scrollPane = null;
			Fachada fachada = new Fachada();
			ArrayList<Parcela> parcelas;
			DefaultTableModel modelTable;
			for (int i = 0; i < contratos.size(); i++) {
				
				modelTable = new DefaultTableModel();
				modelTable.addColumn("ID contrato");
				modelTable.addColumn("Valor Mensal");
				modelTable.addColumn("Data de Vencimento");

				tabela = new JTable(modelTable);
				tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
				tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
				tabela.setBounds(0, 0, 1200, 400);

				parcelas = fachada.buscarParcelaPorContratoID(contratos.get(i).getId());
				modelTable.setNumRows(0);
				for (Parcela parcela : parcelas) {
					String[] linha = { String.valueOf(contratos.get(i).getId()), String.valueOf(parcela.getValor()),
							parcela.getData_vencimento() };
					modelTable.addRow(linha);
				}
				scrollPane = new JScrollPane(tabela);
				scrollPanes.add(scrollPane);
			}

			for (JScrollPane jScrollPaneAtual : scrollPanes) {
				jScrollPaneAtual.setBounds(x, y, largura, altura);
				add(jScrollPaneAtual);
				y += 200;
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	public Botao getBtnNovoContrato() {
		return btnNovoContrato;
	}
	// public JScrollPane getBarraRolagem() {
	// return barraRolagem;
	// }
	// public void setBarraRolagem(JScrollPane barraRolagem) {
	// this.barraRolagem = barraRolagem;
	// }
	// public JScrollPane getBarra2() {
	// return barra2;
	// }
	// public void setBarra2(JScrollPane barra2) {
	// this.barra2 = barra2;
	// }

}
