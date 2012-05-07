package warborn.model;

import javax.swing.ImageIcon;

public class CardDeck {
	private ImageIcon infantryImage, cavaleryImage, artilleryImage;
	private final String LESSERTROOP = "Infantry", COMMONTROOP = "Cavalery", GREATERTROOP = "Artillery"; 
	
	public CardDeck(){
		
	infantryImage = new ImageIcon("WarbornData/images/infantry.jpg");
	cavaleryImage = new ImageIcon("WarbornData/images/cavalry.jpg");
	artilleryImage =new ImageIcon("WarbornData/images/artillery.jpg");
	}
	
	public static int getMaxValue(){
		return 3;
	}
	
	public Card drawCard(){
		double d = Math.random()*getMaxValue();
		int i = (int)d;
		switch(i){
		case 0:
			return new Card(LESSERTROOP, infantryImage, 0);
		case 1:
			return new Card(COMMONTROOP, cavaleryImage, 1);
		case 2:
			return new Card(GREATERTROOP, artilleryImage, 2);
		default:
			//If this card is created something went wrong
			return new Card("Something went wrong!!", null, -1);
		}	
	}
	
}
