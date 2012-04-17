package warborn.model.spells;

import warborn.model.Warborn;

public class FireBall extends Spell {

	public FireBall(int mana, int time) {
		super(mana, time);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() != model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Fireball";
	}

	@Override
	public String getDescription() {
		return "Destroy 3 troops in target territory to a minium of 1 \n \n \" Toast 'em \" ";
	}

	@Override
	public void invoke(Warborn model) {
		model.getCurrentPlayer().changeMana(-this.getManaCost());
		if(model.getSelectedTerritory().getNbrOfUnits() < 4){
			model.getSelectedTerritory().setNbrOfUnits(1);
		}
		else{
			model.getSelectedTerritory().setNbrOfUnits(model.getSelectedTerritory().getNbrOfUnits() - 3);
		}
	}

}
