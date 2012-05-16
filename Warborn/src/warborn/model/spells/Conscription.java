package warborn.model.spells;

import warborn.model.Warborn;

public class Conscription extends Spell {

	public Conscription(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() == model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Conscription";
	}

	@Override
	public String getDescription() {
		return "add two additional troops to target territory  \n " +
				"unless you controll 5 or less territories then add 5 troops instead " +
				"\n \n  \"We need volunteers... you and you follow me\"";
	}

	@Override
	public void invoke(Warborn model) {
		if(model.getCurrentPlayer().getNbrOfTerritories() > 5){
			model.getSelectedTerritory().incrementUnits(2);
		}
		else {
			model.getSelectedTerritory().incrementUnits(5);
		}
	}
}
