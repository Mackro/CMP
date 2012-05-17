package warborn.model.spells;

public class Beguile extends Spell{

	public Beguile(int mana) {
		super(mana);
		
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Beguile";
	}

	@Override
	public String getDescription() { 
		return "The owner of target territory becomes your plaything" + "\n \n \"Come here boy\" ";
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getSelectedTerritory().getOwner().setAdditionalName(" Plaything of " + target.getCurrentPlayer().getName());
	}

}
