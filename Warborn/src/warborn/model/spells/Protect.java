package warborn.model.spells;

import warborn.model.Warborn;

public class Protect extends Spell {
	
	public Protect(int mana) {
		super(mana);
	}

	@Override
	public void invoke(Warborn model) {
		timer = model.getNumberOfPlayers()-1;
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		model.getSelectedTerritory().setProtected(true);
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

}
