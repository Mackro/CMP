package warborn.model.spells;

public class HolyLight extends Spell {

	public HolyLight(int mana) {
		super(mana);
		// TODO Auto-generated constructor stub
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
		return "Holy Light";
	}

	@Override
	public String getDescription() {
		return "Reinforce target territory with 4 troops \n \n \"A gift from the skies \" ";
	}

}
