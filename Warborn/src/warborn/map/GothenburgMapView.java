package warborn.map;

import warborn.model.Warborn;

public class GothenburgMapView extends Map { 	

	/**
	 * Create the Map panel.
	 */
	public GothenburgMapView(Warborn model) {
		super(model);

	}	

	public static String getMapName(){
		return "Asgauter";
	}
	
	public String toString(){
		return "Asgauter";
	}


}
