package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalCaixa extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	public InternalCaixa(TelaPrincipal telaPrincipal) throws BusinessException {
		super("Caixa", telaPrincipal);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar() throws BusinessException {
		bntEditar = new Botao("resource/imagens/botoes/editar-caixa.png","Editar caixa");
		bntEditar.setBounds(50, 20, 210, 40);
		getContentPane().add(bntEditar);

		bntNovo = new Botao("resource/imagens/botoes/adicionar-caixa.png","Nova caixa");
		bntNovo.setBounds(290, 20, 201, 40);
		getContentPane().add(bntNovo);

		bntRemover = new Botao("resource/imagens/botoes/remover-caixa.png","Remover caixa");
		bntRemover.setBounds(520, 20, 230, 40);
		getContentPane().add(bntRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Cidade");

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);

		getContentPane().add(barraRolagem);
	}

	public void carregarcaixa(List<Caixa> caixas) throws BusinessException {
		for (Caixa caixa : caixas) {
			Cidade cidade = new Fachada().buscarCidadePorId(caixa.getCidade_id());
			
			String[] linha = {caixa.getId().toString(), caixa.getNome(), cidade.getNome()};
			modelTable.addRow(linha);
		}

	}
}
