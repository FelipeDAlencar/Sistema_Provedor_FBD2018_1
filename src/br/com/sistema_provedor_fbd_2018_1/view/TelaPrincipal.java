package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaPrincipal extends Tela{
	private Menu menu;
	private BotaoDesktop bntAdicionarCliente;
	private BotaoDesktop bntVerCliente;
	private BotaoDesktop bntAdicionarSwitch;
	private BotaoDesktop bntAtendimentos;
	private BotaoDesktop bntMovimentacoes;
	private JLabel bgImage;
	private JDesktopPane desktopPane;
	private InternalAdicionarCliente adicionarCliente;
	
	public TelaPrincipal() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 50,(int)tela.getWidth(),(int)tela.getHeight()-50);
		
		bgImage = new JLabel(new ImageIcon("resource/imagens/bg-app-main.jpg"));
		bgImage.setBounds(0, 0, desktopPane.getWidth(),(int) tela.getHeight());
		
		
		desktopPane.add(bgImage);
		getContentPane().add(desktopPane);	
		
		ImageIcon imagemTituloJanela = new ImageIcon("res/icon.png");
		setIconImage(imagemTituloJanela.getImage());
		
		setVisible(true);

	}
		
	@Override
	public void inicializar() {
		menu = new Menu();
		
		
		bntAdicionarCliente = new BotaoDesktop("resource/imagens/desktop/adicionarCliente.png","Adicionar Cliente");
		bntAdicionarCliente.setBounds(150,100,250,180);
		
		bntVerCliente = new BotaoDesktop("resource/imagens/desktop/verCliente.png", "Localizar Cliente");
		bntVerCliente.setBounds(550, 100, 250, 180);
		
		bntAdicionarSwitch = new BotaoDesktop("resource/imagens/desktop/adicionarSwitch.png", "Adicionar Switch");
		bntAdicionarSwitch.setBounds(950, 100, 250, 180);
		
		bntAtendimentos = new BotaoDesktop("resource/imagens/desktop/atendimento.png", "Atendimentos");
		bntAtendimentos.setBounds(350, 400, 250, 180);
		
		bntMovimentacoes = new BotaoDesktop("resource/imagens/desktop/movimentacao.png", "Movimentações");
		bntMovimentacoes.setBounds(750, 400, 250, 180);
		
		getContentPane().add(menu);
		getContentPane().add(bntAdicionarCliente);
		getContentPane().add(bntVerCliente);
		getContentPane().add(bntAdicionarSwitch);
		getContentPane().add(bntAtendimentos);
		getContentPane().add(bntMovimentacoes);
		
	}
	
	public void desativarBotoes() {
		bntAdicionarCliente.setVisible(false);
		bntVerCliente.setVisible(false);
		bntAdicionarSwitch.setVisible(false);
		bntAtendimentos.setVisible(false);
		bntMovimentacoes.setVisible(false);
	}
	
	public void ativarBotoes() {
			bntAdicionarCliente.setVisible(true);
			bntVerCliente.setVisible(true);
			bntAdicionarSwitch.setVisible(true);
			bntAtendimentos.setVisible(true);
			bntMovimentacoes.setVisible(true);
	}

	public Menu getMenu() {
		return menu;
	}

	public BotaoDesktop getBntAdicionarCliente() {
		return bntAdicionarCliente;
	}

	public BotaoDesktop getBntVerCliente() {
		return bntVerCliente;
	}

	public BotaoDesktop getBntAdicionarSwitch() {
		return bntAdicionarSwitch;
	}

	public BotaoDesktop getBntAtendiemntos() {
		return bntAtendimentos;
	}

	public BotaoDesktop getBntMovimentacoes() {
		return bntMovimentacoes;
	}

	public JLabel getBgImage() {
		return bgImage;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public InternalAdicionarCliente getAdicionarCliente() {
		return adicionarCliente;
	}
	
	
	

}
