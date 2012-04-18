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
		return "Destroy 5 troops in each territory on the map to a minium of 1 \n \n \"That's it! \" ";
	}

	@Override
	public void invoke(Warborn model) {
		timer = 0;
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		for(Territory territory : model.getTerritories()){
			if(territory.getNbrOfUnits() < 6){
				territory.setNbrOfUnits(1);
			}
			else{
				territory.setNbrOfUnits(territory.getNbrOfUnits() - 5);
			}
		}
	}

}
