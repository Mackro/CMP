package warborn.model;

import warborn.map.IMap;

public class Model {
	
	private Player[] players;
	private Territory[] territories;
	
	public Model (Player[] players, Territory[] territories){
		this.players = players;
		this.territories = territories;
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
