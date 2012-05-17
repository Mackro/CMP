package warborn.model.spells;

public class Affection extends Spell{
	
	private final static String DESCRIPTION  = "Target player expresses his affection towards you \" Love is in the air <3\"";
			
	private final static String NAME = "Affection";	
			
	public Affection(int mana) {
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
		target.getSelectedTerritory().getOwner().setAdditionalName(" <3 " + target.getCurrentPlayer().getName());
	}

}
