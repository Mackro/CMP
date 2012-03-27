package warborn.controller;

import java.util.Observable;
import java.util.Observer;

import warborn.map.IMap;
import warborn.model.Warborn;

public class MapController implements Observer {
	
	private Warborn model;
	
	public MapController(Warborn model){
		this.model = model;
	}

	@Override
	public void update(Observable mapView, Object e) {
		if (!(mapView instanceof IMap)){
			return;
		}
		
		System.out.println(e +"   controller");
		model.setSelectedTerritory((Integer)e);
	}

}
