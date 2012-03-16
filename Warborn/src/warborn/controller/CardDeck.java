package warborn.controller;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CardDeck {
	private ImageIcon infantryImage, cavaleryImage, artilleryImage;
	private final String LESSERTROOP = "Infantry", COMMONTROOP = "Cavalery", GREATERTROOP = "Artillery"; 
	
	public CardDeck(){
		
	infantryImage = new ImageIcon("images/infantry.jpg");
	cavaleryImage = new ImageIcon("images/cavalery.jpg");
	artilleryImage =new ImageIcon("images/artillery.jpg");
	}
	
	public Card drawCard(){
		double d = Math.random()*3;
		int i = (int)d;
		switch(i){
		case 0:
			return new Card(LESSERTROOP, infantryImage, 0);
		case 1:
			return new Card(COMMONTROOP, cavaleryImage, 1);
		default:
			return new Card(GREATERTROOP, artilleryImage, 2);
		}	
	}
	
}
