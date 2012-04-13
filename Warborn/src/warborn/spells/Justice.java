package warborn.spells;

import warborn.model.Warborn;

public class Justice extends Spell {

	public Justice(int mana) {
		super(mana);
	}

	@Override
	public void invoke(Warborn model) {
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		model.getSelectedTerritory().decrementUnits(2);
	}
}
