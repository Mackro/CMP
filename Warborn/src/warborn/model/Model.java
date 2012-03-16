package warborn.model;

import java.awt.Color;
import java.util.Observable;

import warborn.map.IMap;

public class Model extends Observable{
	
	private Player[] players;
	private Territory[] territories;
	private IMap[] maps;
	private int selectedMap;
	
	public Model (){
		this.players = new Player[2];
		this.territories = null;
	}
	

	public Player[] getPlayers(){
		return players;
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
	
	public void setPlayers(String[] names, Color[] colours){
		players = new Player[names.length];
		for(int i = 0; i < names.length; i++){
			players[i] = new Player(names[i], i, colours[i]);
		}
	}
	
	public void setSelectedMap(int id){
		this.selectedMap = id;
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

}
