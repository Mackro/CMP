package warborn.model.spells;

import warborn.model.Territory;
import warborn.model.Warborn;

public class TimeOfTruce extends Spell {

	public TimeOfTruce(int mana) {
		super(mana);
	}

	@Override
	public void invoke(Warborn model) {
		this.setTimer(model.getNumberOfPlayers()-1);
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		for(Territory territory : model.getTerritories()){
			territory.setProtected(true);
		}
	}

	@Override
	public boolean validTarget(Warborn model) {
		return true;
	}

	@Override
	public String getName() {
		return "Time Of Truce";
	}

	@Override
	public String getDescription() {
		return "Protects all territories on the map from being attacked or targeted by spells for one turn \n \n \"Much work for making sure nothing happens \" ";
	}

	@Override
	public void tick() {
		this.setTimer(this.getTimer()-1);
	}
	
	public boolean isInstant(){
		return true;
	}
}
