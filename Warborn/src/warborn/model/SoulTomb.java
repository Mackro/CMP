package warborn.model;

import javax.swing.ImageIcon;

public class SoulTomb {
	private ImageIcon lesserImage, commonImage, greaterImage;
	private final String LESSERSOUL = "Lesser Soul", COMMONSOUL = "Common Soul", GREATERSOUL = "Greater Soul"; 
	private final static int LESSERINDEX = 0, COMMONINDEX = 1, GREATERINDEX = 2, ERRORINDEX = -1;

	public SoulTomb(){

		lesserImage = new ImageIcon("WarbornData/images/infantry.png");
		commonImage = new ImageIcon("WarbornData/images/cavalry.png");
		greaterImage = new ImageIcon("WarbornData/images/artillery.png");
	}

	public static int getMaxValue(){
		return 3;
	}

	public Soul drawSoul(){
		double d = Math.random()*getMaxValue();
		int i = (int)d;
		switch(i){
		case 0:
			return new Soul(LESSERSOUL, lesserImage, LESSERINDEX);
		case 1:
			return new Soul(COMMONSOUL, commonImage, COMMONINDEX);
		case 2:
			return new Soul(GREATERSOUL, greaterImage, GREATERINDEX);
		default:
			//If this card is created something went wrong
			return new Soul("Something went wrong!!", null, ERRORINDEX);
		}	
	}

}
