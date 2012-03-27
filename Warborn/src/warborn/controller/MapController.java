package warborn.controller;

import java.util.Observable;
import java.util.Observer;

import warborn.map.IMap;
import warborn.model.Warborn;

public class MapController implements Observer {
	
	public MapController(Warborn model){
		
	}

	@Override
	public void update(Observable mapView, Object e) {
		
		if (!(mapView instanceof IMap)){
			return;
		}
		model.setSelectedTerritory((Integer)e);
	}

}
