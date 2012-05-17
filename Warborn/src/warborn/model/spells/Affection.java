package warborn.model.spells;

public class Affection extends Spell{

	public Affection(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Affection";
	}

	@Override
	public String getDescription() {
		return "Target player expresses his affection towards you \" Love is in the air <3\"";
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().getOwner().setAdditionalName(" <3 " + target.getCurrentPlayer().getName());
	}

}
