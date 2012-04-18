package warborn.model.spells;

import warborn.model.Warborn;

public class HolyLight extends Spell {

	public HolyLight(int mana) {
		super(mana);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void invoke(Warborn model) {
		timer = 0;
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		model.getSelectedTerritory().incrementUnits(2);
		
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
		return "Reinforce target territory with two troops \n \n \"A gift from the skies \" ";
	}

}
