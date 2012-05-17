package warborn.model.spells;

public class RagingElements extends Spell {
	
	private final static String DESCRIPTION = "Destroy 2 troop in target territory  \n \n \" Achtung enraged titan \" ";
			
	private final static String NAME = "Raging Elements";

	public RagingElements(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return 	(target.getSelectedTerritory().getNbrOfUnits() > 1) && (target.getSelectedTerritory().getOwner() != target.getCurrentPlayer());
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().decrementUnits(2);
	}

}
