package warborn.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardTester{
	
	private static Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	private static Dimension dim = toolkit.getScreenSize();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(getScreenWidth(), getScreenHeight());
		CardDeck deck = new CardDeck();
		Card card = deck.drawCard();
		JPanel jp = new JPanel();
		JButton jb = new JButton();
		jb.setIcon(card.getImage());
		jf.add(jp);
		jp.add(jb);
		jf.setVisible(true);
		
	}
	
	
	  
	public static int getScreenWidth(){

		return (int)dim.getWidth();
	}  
	
	public static int getScreenHeight(){
		return (int)dim.getHeight();
	}

}
