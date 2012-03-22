package warborn.model;

public class Move extends Template {
	
	public void moveUnits(int antal){
		getFirstTerritory().setNbrOfUnits(getFirstTerritory().getNbrOfUnits() - antal);
		getSecondTerritory().setNbrOfUnits(getSecondTerritory().getNbrOfUnits() + antal);
		
	}
	
}
