package warborn.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import warborn.map.*;

public class Warborn extends Observable{

	private ArrayList<Player> players;
	private Territory[] territories;
	private IMap[] maps;
	private Move move;
	private Battle battle;
	private int selectedMap = 0, currentPlayer = 0, selectedTerritory = -1;
	private int state = 0, phase = 0;
	private Dimension dimension;


	public Warborn (){
		Toolkit kit = Toolkit.getDefaultToolkit();
		dimension = kit.getScreenSize();
		this.players = new ArrayList<Player>();
		addPlayer("Player 1", Color.BLUE);
		addPlayer("Player 2", Color.RED);
		try {
			this.territories = TerritoryFactory.getTerritories("Gothenburg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i = 0; i<territories.length; i++){
			territories[i].setNbrOfUnits(4);
		}
		this.battle = new Battle(this);
		this.move = new Move(this);
		initMaps();

		//TODO real implementation
		for(int i  = 0; i < territories.length/2; i++){
			territories[i].setOwner(players.get(0));
		}
		for(int i  = territories.length/2; i < territories.length; i++){
			territories[i].setOwner(players.get(1));
		}
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

	/**
	 * Retruns the current state of the model
	 * @return 0 - if currently the program state is in <code>Menu</code><br>
	 * 1 - if currently the program state is in <code>Unit Placement</code><br>
	 * 2 - if currently the program state is in <code>Attack</code><br>
	 * 3 - if currently the program state is in <code>Move</code>
	 */
	public int getState(){
		return state;
	}

	/**
	 * Retruns the current phase of the model
	 * @return 0 - if currently the program phase is <code>normal</code><br>
	 * 1 - if currently the program state is <code>action</code>
	 */
	public int getPhase(){
		return phase;
	}

	public IMap getMap(){
		return maps[selectedMap];
	}

	public Player getCurrentPlayer(){
		return players.get(currentPlayer);
	}

	public int getSelectedTerritoryIndex(){
		return selectedTerritory;
	}

	public Move getMove(){
		return move;
	}

	public Battle getBattle(){
		return battle;
	}

	public int getWidth(){
		return dimension.width;
	}

	public int getHeight(){
		return dimension.height;
	}

	public Territory getTerritory(int i){
		return territories[i];

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

	public void setSelectedTerritory(int id){
		System.out.println(selectedTerritory + "; " + id);
		if (selectedTerritory != id){
			//	System.out.println(selectedTerritory + ", " + phase + ", " + state);
			if(state == 1 && players.get(currentPlayer) == territories[id].getOwner()){
				territories[id].incrementUnit();
				//	System.out.println(selectedTerritory + ", " + phase + ", " + state);
			}else if(state != 1 && players.get(currentPlayer) == territories[id].getOwner()){
				if(selectedTerritory == -1){
					battle.add(territories[id]);
					move.add(territories[id]);
					selectedTerritory = id;
				}else if(state == 2 && attackCompatible(territories[selectedTerritory], territories[id])){
					battle.add(territories[id]);
					selectedTerritory = -1;
					nextPhase();
					//	System.out.println(selectedTerritory + ", " + phase + ", " + state);
				}else if(state == 3 && moveCompatible(territories[selectedTerritory], territories[id])){
					move.add(territories[id]);
					selectedTerritory = -1;
					nextPhase();
					//	System.out.println(selectedTerritory + ", " + phase + ", " + state);
				}
			}
		}else{
			selectedTerritory = -1;
		}
		changed();
	}

	//End Setters

	public void addPlayer(String name, Color colour){
		players.add(new Player(name, players.size(), colour));
		changed();
	}

	public void nextState(){
		this.state++;
		if(this.state > 3){
			this.state = 1;
		}
		changed();
	}

	public void nextPhase(){
		this.phase = (this.phase+1)%2;
		changed();
		//TODO reset territories in Templates
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
		if(this.state != 0){
			return;
		}
		try {
			territories = TerritoryFactory.getTerritories(getMap().toString());
		} catch (IOException e) {
			System.out.println("Selected Map does not exist!");
		}
		this.phase = 0;
		nextState();
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
		selectedMap = 0;
		maps = new IMap[1];
		maps[0] = new GothenburgMapView(this);
	}


	protected void changed() {
		setChanged();
		notifyObservers();
	}

}
