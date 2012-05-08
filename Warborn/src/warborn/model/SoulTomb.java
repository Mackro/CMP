package warborn.model;

import javax.swing.ImageIcon;

public class SoulTomb {
	private ImageIcon lesserImage, commonImage, greaterImage;
	private final String LESSERSOUL = "Lesser Soul", COMMONSOUL = "Common Soul", GREATERSOUL = "Greater Soul"; 
	
	public SoulTomb(){
		
	lesserImage = new ImageIcon("WarbornData/images/infantry.png");
	commonImage = new ImageIcon("WarbornData/images/cavalry.png");
	greaterImage = new ImageIcon("WarbornData/images/artillery.png");
	}
	
	public static int getMaxValue(){
		return 3;
	}
	
	public Soul drawCard(){
		double d = Math.random()*getMaxValue();
		int i = (int)d;
		switch(i){
		case 0:
			return new Soul(LESSERSOUL, lesserImage, 0);
		case 1:
			return new Soul(COMMONSOUL, commonImage, 1);
		case 2:
			return new Soul(GREATERSOUL, greaterImage, 2);
		default:
			//If this card is created something went wrong
			return new Soul("Something went wrong!!", null, -1);
		}	
	}
	
}
