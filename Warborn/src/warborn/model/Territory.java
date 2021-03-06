package warborn.model;

import java.util.ArrayList;

import warborn.model.spells.Liveable;

public class Territory implements Liveable{
	
	private ArrayList <Territory> connections;
	private Player owner;
	private int nbrOfUnits = 0, id;
	private String name;
	private boolean protection;
	
	public Territory(String name, int id){
		this.id = id;
		connections = new ArrayList<Territory>();
		owner = null;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public int getId() {
		return id;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public int getNbrOfUnits(){
		return this.nbrOfUnits;
	}
	
	public void setOwner(Player newOwner){
		this.owner = newOwner;
	}
	
	public void setProtected(boolean protection){
		this.protection = protection;
	}
	
	public void setNbrOfUnits(int nbrOfUnits){
		this.nbrOfUnits = nbrOfUnits;
	}
	
	public void incrementUnit(){
		this.nbrOfUnits++;
	}
	
	public void incrementUnits(int units){
		this.nbrOfUnits = nbrOfUnits + units;
	}
	
	public void decrementUnit(){
		this.nbrOfUnits--;
	}
	
	public void decrementUnits(int units){
		this.nbrOfUnits = nbrOfUnits - units;
	}
	
	public boolean hasConnection(Territory compareTo){
		if(connections == null){
			return false;
		}
		for(int i = 0; i < connections.size(); i++){
			if(connections.get(i).equals(compareTo)){
				return true;
			}
		}
		return false;
	}
	
	public void addConnection(Territory toAdd){
		connections.add(toAdd);
	}
	
	public boolean isProtected(){
		return protection;
	}
}