package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BotaoDesktop extends JButton{
	private JLabel icone;
	private JLabel tituloBotao;
	public BotaoDesktop(String caminho, String titulo) {
		setLayout(null);
		
		icone = new JLabel(new ImageIcon(caminho));
		icone.setBounds(75, 20, 100, 100);
		
		tituloBotao = new JLabel(titulo);
		tituloBotao.setBounds(80, 100, 100, 100);
		tituloBotao.setFont(new Font("Arial", Font.BOLD,12));
		
		add(icone);
		add(tituloBotao);
	}

}
