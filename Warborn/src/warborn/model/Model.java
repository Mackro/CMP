package warborn.model;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import warborn.main.TerritoryFactory;
import warborn.map.GothenburgMap;
import warborn.map.IMap;

public class Model extends Observable{
	
	private ArrayList<Player> players;
	private Territory[] territories;
	private IMap[] maps;
	private int selectedMap, currentPlayer, selectedTerritory;
	private int state = 0;
	
	public Model (){
		this.players = new ArrayList<Player>();
		this.territories = null;
		initMaps();
	}
	

	//Getters
	
	public Player[] getPlayers(){
		return (Player[])players.toArray();
	}
	
	public Territory[] getTerritories(){
		return territories;
	}
	
	public String[] getMapNames(){
		String[] names = new String[maps.length];
		for(int i = 0; i < maps.length; i++){
			names[i] = maps[i].toString();
		}
		return names;
	}
	
	public int getState(){
		return state;
	}
	
	public IMap getMap(){
		return maps[selectedMap];
	}
	
	public int getCurrentPlayerIndex(){
		return currentPlayer;
	}
	
	public int getSelectedTerritoryIndex(){
		return selectedTerritory;
	}
	
	//TODO implement
	public int getWidth(){
		return 800;
	}
	
	public int getHeight(){
		return 600;
	}
	
	
	//Setters:
	
	public void setPlayers(String[] names, Color[] colours){
		for(int i = 0; i < names.length; i++){
			players.add(new Player(names[i], i, colours[i]));
		}
		changed();
	}


	public void setSelectedMap(int id){
		this.selectedMap = id;
		changed();
	}
	
	//End Setters
	
	public void addPlayer(String name, Color colour){
		players.add(new Player(name, players.size(), colour));
		changed();
	}
	
	public void removePlayer(){
		removePlayer(players.size()-1);
		changed();
	}
	
	public void removePlayer(int id){
		players.remove(id);
		changed();
	}
	
	public void startGame(){
		try {
			territories = TerritoryFactory.getTerritories(getMap().toString());
		} catch (IOException e) {
			System.out.println("Selected Map does not exist!");
		}
	}
	
	public boolean attackCompatible(Territory t1, Territory t2){
		if(!t1.hasConnection(t2) || t1.getOwner().getID() == t2.getOwner().getID()){
			return false;
		}
		return true;
	}
	
	public boolean moveCompatible(Territory t1, Territory t2){
		if(!t1.hasConnection(t2) || t1.getOwner().getID() != t2.getOwner().getID()){
			return false;
		}
		return true;
	}
	
	private void initMaps(){
		maps = new IMap[1];
		maps[0] = new GothenburgMap();
	}
	
	private void changed() {
		hasChanged();
		notifyObservers();
	}

}
