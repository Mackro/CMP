package warborn.model;

public class Battle extends Template {
	
	private Model model;
	private int a1, a2, a3, d1, d2;
	private Dice dice;
	
	public Battle(Model model){
		this.model = model;	
	}
	
	public int fight(){
		if(model.getBattle().getFirstTerritory().getNbrOfUnits() >= 3){
			a1 = dice.d6Roll();
			
		}
	}
}
