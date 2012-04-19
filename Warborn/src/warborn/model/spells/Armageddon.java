package warborn.model.spells;


import warborn.model.Territory;
import warborn.model.Warborn;

public class Armageddon extends Spell {

	public Armageddon(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return true;
	}

	@Override
	public String getName() {
		return "Armageddon";
	}

	@Override
	public String getDescription() {
		return "Destroy 5 troops in each territory on the map to a minium of 1, and 1 additional damage next turn \n \n \"That's it! \" ";
	}

	@Override
	public void invoke(Warborn model) {
		setTimer(model.getPlayers().length);
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		for(Territory territory : model.getTerritories()){
			if(territory.getNbrOfUnits() < 6){
				territory.setNbrOfUnits(1);
			}
			else{
				territory.decrementUnits(5);
			}
		}
	}
	
	@Override
	public void tick(Warborn model){
		decrementTimer();
		if(getTimer() == 0){
			for(Territory terry : model.getTerritories()){
				if(terry.getNbrOfUnits() < 2){
					terry.setNbrOfUnits(1);
				}else{
					terry.decrementUnit();
				}
			}
		}
	}

}
