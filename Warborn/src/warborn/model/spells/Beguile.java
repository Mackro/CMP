package warborn.model.spells;

public class Beguile extends Spell{
	private final static String DESCRIPTION = "The owner of target territory becomes your plaything" + "\n \n \"Come here boy\" ";
	
	private final static String NAME = "Beguile";

	public Beguile(int mana) {
		super(mana);
		
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer();
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
		target.getSelectedTerritory().getOwner().setAdditionalName(" Plaything of " + target.getCurrentPlayer().getName());
	}

}
