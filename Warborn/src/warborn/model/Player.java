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
	
	public int getNbrOfTerritories(){
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

	
	public boolean canExchangeCards(){
		int[] nbrOfCards = new int[CardDeck.getMaxValue()];
		for (int i=0; i<cards.length; i++){
			nbrOfCards[cards[i].getIndex()]++;
			if(nbrOfCards[cards[i].getIndex()] > 2){
				return true;
			}
		}
		for(int i = 0; i < nbrOfCards.length; i++){
			if(nbrOfCards[i] < 1){
				return false;
			}
		}
		return true;
		
		
	}
}
