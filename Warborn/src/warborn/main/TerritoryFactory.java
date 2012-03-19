package warborn.main;

import java.awt.Color;
import java.io.*;

import warborn.model.*;
import warborn.map.*;

public class TerritoryFactory {

	
	public static Territory[] getTerritories(String mapName) throws IOException{
		File file = new File(mapName + ".txt");
		LineNumberReader lnr = new LineNumberReader(new FileReader(file));
		lnr.skip(file.length()-1);
		int lines = lnr.getLineNumber();
		BufferedReader in = new BufferedReader(new FileReader(file));
		Territory[] territories = new Territory[lines];
		
		
		
		return territories;
	}
	
}
