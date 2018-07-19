package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalConcentrador extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	public InternalConcentrador(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Concentrador", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(true);
	}

	@Override
	public void inicializar() throws BusinessException {
		bntEditar = new Botao("resource/imagens/botoes/editar-concentrador.png","Editar Concentrador");
		bntEditar.setBounds(50, 20, 210, 40);
		getContentPane().add(bntEditar);

		bntNovo = new Botao("resource/imagens/botoes/adicionar-concentrador.png","Nova Concentrador");
		bntNovo.setBounds(290, 20, 201, 40);
		getContentPane().add(bntNovo);

		bntRemover = new Botao("resource/imagens/botoes/remover-concentrador.png","Remover Concentrador");
		bntRemover.setBounds(520, 20, 230, 40);
		getContentPane().add(bntRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("IP");

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);

		getContentPane().add(barraRolagem);
	}

	public void carregarConcentrador(List<Concentrador> concentradores) {
		for (Concentrador concentrador : concentradores) {

			String[] linha = {concentrador.getId().toString(), concentrador.getNome(), concentrador.getIp()};
			modelTable.addRow(linha);
		}

	}
}
