package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Botao extends JButton{
	private JLabel icone;
	private JLabel tituloBotao;
	public Botao(String caminho, String titulo) {
		setLayout(null);
		icone = new JLabel(new ImageIcon(caminho));
		icone.setBounds(10, 10, 20, 20);
		
		tituloBotao = new JLabel(titulo);
		tituloBotao.setBounds(40, 15, 200, 10);
		tituloBotao.setFont(new Font("Arial", Font.BOLD,14));
		
		add(icone);
		add(tituloBotao);
	}
	
	

}
