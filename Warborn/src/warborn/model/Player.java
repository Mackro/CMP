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
		this.color = color;
	}
	
	public int getID(){
		return id;
	}

	public void addTerritory(Territory toAdd){
		toAdd.setOwner(this);
		nbrOfTerritories++;
	}
	
	public void removeTerritory(){
		nbrOfTerritories--;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void addCard(Card newCard){
		for(int i = 0; i < cards.length; i++){
			if(cards[i] == null){
				cards[i] = newCard;
			}
		}
	}
	
	public void removeCard(int id){
		for(int i = id; i < cards.length-1; i++){
			cards[id] = cards[id+1]
		}
		cards[cards.length] == null;
	}
	
}
