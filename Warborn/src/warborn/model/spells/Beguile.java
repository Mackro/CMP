package warborn.model.spells;

import warborn.model.Warborn;

public class Beguile extends Spell{

	public Beguile(int mana) {
		super(mana);
		
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() != model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Beguile";
	}

	@Override
	public String getDescription() { 
		return "The owner of target territory becomes your plaything" + "\n \n \"Come here boy\" ";
	}

	@Override
	public void invoke(Warborn model) {
		model.getSelectedTerritory().getOwner().setAdditionalName(" Plaything of " + model.getCurrentPlayer().getName());
		model.getCurrentPlayer().changeMana(-this.getManaCost());
	}

}
