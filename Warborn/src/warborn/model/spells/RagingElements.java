package warborn.model.spells;

public class RagingElements extends Spell {

	public RagingElements(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return 	(target.getSelectedTerritory().getNbrOfUnits() > 1) && (target.getSelectedTerritory().getOwner() != target.getCurrentPlayer());
	}

	@Override
	public String getName() {
		return "Raging Elements";
	}

	@Override
	public String getDescription() {
		return "Destroy 2 troop in target territory  \n \n \" Achtung enraged titan \" ";
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().decrementUnits(2);
	}

}
