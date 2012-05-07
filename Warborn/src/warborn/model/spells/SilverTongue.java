package warborn.model.spells;

import warborn.model.Warborn;

public class SilverTongue extends Spell {

	public SilverTongue(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return (model.getSelectedTerritory().getNbrOfUnits() > 1) && (model.getSelectedTerritory().getOwner() != model.getCurrentPlayer()) && (model.getState() == 1);
	}

	@Override
	public String getName() {
		return "Silver Tongue";
	}

	@Override
	public String getDescription() {
		return "cajole 1 enemy troop in target territory to join your cause " +
				"\n Use only in your reinforcement phase, on territories with more than 1 troop \n \n \"Come over to the dark side we have... \" ";
	}

	@Override
	public void invoke(Warborn model) {
		model.getSelectedTerritory().decrementUnit();
		model.setNbrOfReinforcements(model.getNbrOfReinforcements()+1);
		model.getCurrentPlayer().changeMana(-this.getManaCost());
	}

}
