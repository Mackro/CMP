package warborn.model;

import java.awt.Color;

public class Player {

	private int id, nbrOfTerritories = 0;
	private String name;
	private Color color;
	private Card[] cards = new Card[5];
	
	public Player(String name, int id, Color color){
		this.name = name;
		this.id = id;
		Color copiedColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
		this.color = copiedColor;
	}
	
	public int getID(){
		return id;
	}
	
	public int getNbrOfTerretories(){
		return nbrOfTerritories;
	}
	
	public Color getColor(){
		Color copiedColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
		return copiedColor;
	}
	
	public String getName(){
		return name;
	}

	public void addTerritory(Territory toAdd){
		toAdd.setOwner(this);
		nbrOfTerritories++;
	}
	
	public void removeTerritory(){
		nbrOfTerritories--;
	}
	
	
	public void addCard(Card newCard){
		for(int i = 0; i < cards.length; i++){
			if(cards[i] == null){
				cards[i] = newCard;
				break;
			}
		}
	}


	public void removeCard(int id){
		for(int i = 0; i < cards.length; i++){
			if(cards[i].getIndex() == id){
				for(int j = i; j < cards.length-1; j++){
					cards[j] = cards[j+1];
				}
				cards[cards.length] = null;
				break;
			}
		}
	}
}
