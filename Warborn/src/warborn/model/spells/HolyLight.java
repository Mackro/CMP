package warborn.model.spells;

public class HolyLight extends Spell {

	private final static String DESCRIPTION = "Reinforce target territory with 4 troops \n \n \"A gift from the skies \" "; 
	private final static String NAME = "Holy Light";
	
	public HolyLight(int mana) {
		super(mana);
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().incrementUnits(3);
		
	}
	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() == target.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
