package warborn.model.spells;

public class SilverTongue extends Spell {

	public SilverTongue(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return (target.getSelectedTerritory().getNbrOfUnits() > 1) && (target.getSelectedTerritory().getOwner() != target.getCurrentPlayer()) && (target.getState() == 1);
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
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().decrementUnit();
		target.setNbrOfReinforcements(target.getNbrOfReinforcements()+1);
	}

}
