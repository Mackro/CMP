package warborn.model;

public class Battle extends Template {
	
	private Model model;
	
	public Battle(Model model){
		this.model = model;	
	}
	
	public int fight(){
		if(model.getBattle().getFirstTerritory().getNbrOfUnits() >= 3){
			
		}
	}
}
