package warborn.model.spells;

import warborn.model.Territory;
import warborn.model.Warborn;

public class Protect extends Spell {
	
	private Territory protectedTerritory;
	
	public Protect(int mana) {
		super(mana);
	}

	@Override
	public void invoke(Warborn model) {
		setTimer(model.getNumberOfPlayers()-1);
		protectedTerritory = model.getSelectedTerritory();
		protectedTerritory.setProtected(true);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return true;
	}

	@Override
	public String getName() {
		return "Protect";
	}

	@Override
	public String getDescription() {
		return "Protects target territory from being attacked or targeted by spells for one turn \n \n \"Always use protection \" ";
	}
	
	@Override
	public void tick(Warborn model){
		decrementTimer();
		if(getTimer() > 0){
			protectedTerritory.setProtected(true);
		}
	}
}
