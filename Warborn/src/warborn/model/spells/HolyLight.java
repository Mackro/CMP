package warborn.model.spells;

import warborn.model.Warborn;

public class HolyLight extends Spell {

	public HolyLight(int mana) {
		super(mana);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void invoke(Warborn model) {
		model.getSelectedTerritory().incrementUnits(3);
		
	}
	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() == model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Holy Light";
	}

	@Override
	public String getDescription() {
		return "Reinforce target territory with 4 troops \n \n \"A gift from the skies \" ";
	}

}
