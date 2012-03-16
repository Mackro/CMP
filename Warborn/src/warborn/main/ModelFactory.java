package warborn.main;

import java.awt.Color;
import java.io.*;

import warborn.model.*;
import warborn.map.*;

public class ModelFactory {

	public static Model createModel(String[] playerNames, Color[] colors, String mapName){
		Player[] players = getPlayers(playerNames, colors);
		Territory[] territories = new Territory[0];
		
		try {
			territories = getTerritories(mapName);
		} catch (FileNotFoundException e) {
			System.out.print("Map not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Model model = new Model(players, territories);
		return model;
	}
	
	private static Player[] getPlayers(String[] playerNames, Color[] colors){
		Player[] players = new Player[playerNames.length];
		for(int i = 0; i < playerNames.length; i++){
			players[i] = new Player(playerNames[i], i, colors[i]);
		}
		return players;
	}
	
	private static Territory[] getTerritories(String mapName) throws IOException{
		File file = new File(mapName + ".txt");
		LineNumberReader lnr = new LineNumberReader(new FileReader(file));
		lnr.skip(file.length()-1);
		int lines = lnr.getLineNumber();
		BufferedReader in = new BufferedReader(new FileReader(file));
		Territory[] territories = new Territory[lines];
		
		
		
		return new Territory[10];
	}
	
}
