package warborn.model.spells;

public class Conscription extends Spell {

	public Conscription(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() == target.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Conscription";
	}

	@Override
	public String getDescription() {
		return "add two additional troops to target territory  \n " +
				"unless you controll 5 or less territories then add 5 troops instead " +
				"\n \n  \"We need volunteers... you and you follow me\"";
	}

	@Override
	public void invoke(SpellTargetable target) {
		if(target.getCurrentPlayer().getNbrOfTerritories() > 5){
			target.getSelectedTerritory().incrementUnits(2);
		}
		else {
			target.getSelectedTerritory().incrementUnits(5);
		}
	}
}
