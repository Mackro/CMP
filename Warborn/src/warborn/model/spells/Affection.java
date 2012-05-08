package warborn.model.spells;

import warborn.model.Warborn;

public class Affection extends Spell{

	public Affection(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() != model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Affection";
	}

	@Override
	public String getDescription() {
		return "Target player expresses his affection towards you \" Love is in the air <3\"";
	}

	@Override
	public void invoke(Warborn model) {
		model.getSelectedTerritory().getOwner().setAdditionalName(" <3 " + model.getCurrentPlayer().getName());
		model.getCurrentPlayer().changeMana(-this.getManaCost());
	}

}
