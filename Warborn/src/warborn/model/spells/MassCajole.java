package warborn.model.spells;

import warborn.model.Territory;
import warborn.model.Warborn;

public class MassCajole extends Spell {
	
	private int bonusTroops;

	public MassCajole(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return true;
	}

	@Override
	public String getName() {
		return "Mass Cajole";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Destroy 1 troop in each enemy territory to a minimum of 1," +
				" each troop destroyed this way you get as reinforcements during your reinforcement phase " +
				"\" The grass is always greener on the other side \" ";
	}

	@Override
	public void invoke(Warborn model) {
		setTimer(model.getNumberOfPlayers());
		for(Territory territory : model.getTerritories()){
			if(territory.getOwner() != model.getCurrentPlayer()){
				bonusTroops++;
			}
		}
	}
	
	public void tick(Warborn warborn){
		decrementTimer();
		if(getTimer() == 0){
			warborn.setNbrOfReinforcements(warborn.getNbrOfReinforcements() + bonusTroops);
		}
	}
	
	@Override
	public boolean isInstant(){
		return true;
	}
}
