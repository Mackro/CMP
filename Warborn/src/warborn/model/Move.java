package warborn.model;

public class Move extends Template {
	
	public void moveUnits(int units){
		getFirstTerritory().setNbrOfUnits(getFirstTerritory().getNbrOfUnits() - units);
		getSecondTerritory().setNbrOfUnits(getSecondTerritory().getNbrOfUnits() + units);
		
	}
	
}
