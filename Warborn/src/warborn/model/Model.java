package warborn.model;

import warborn.map.IMap;

public class Model {
	
	private Player[] players;
	private Territory[] territories;
	private IMap currentMap;
	
	public Model (Player[] players, Territory[] territories, IMap currentMap){
		this.players = players;
		this.territories = territories;
		this.currentMap = currentMap;
	}
	
	public IMap getMap(){
		return currentMap;
	}
	
	public Player[] getPlayers(){
		return players;
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
