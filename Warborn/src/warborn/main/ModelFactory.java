package warborn.main;

import java.awt.Color;

import warborn.model.*;
import warborn.map.*;

public class ModelFactory {

	public static Model createModel(String[] playerNames, Color[] colors, int mapNumber){
		IMap map = getMap(mapNumber);
		Player[] players = getPlayers(playerNames, colors);
		Territory[] territories = getTerritories(map);
		Model model = new Model(players, territories, map);
		return model;
	}
	
	private static IMap getMap(int mapNumber){
		switch(mapNumber){
			case 0:
				return new GothiaCastleMap();
			case 1:
				return new HellMap();
			default:
				return new GothiaCastleMap();
		}
		
	}
	
	private static Player[] getPlayers(String[] playerNames, Color[] colors){
		Player[] players = new Player[playerNames.length];
		for(int i = 0; i < playerNames.length; i++){
			players[i] = new Player(playerNames[i], i, colors[i]);
		}
		return players;
	}
	
	private static Territory[] getTerritories(IMap map){
		Territory[] territories = new Territory[map.getTerritories().length];
		for(int i = 0; i < territories.length; i++){
			territories[i] = new Territory(i);
		}
		return territories;
	}
	
}
