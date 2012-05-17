package warborn.model.spells;

public class Deception extends Spell {

	public Deception(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer(); //&& model.getSelectedTerritory().hasConnection(model.getCurrentPlayer().);
	}

	@Override
	public String getName() {
		return "Purge";
	}

	@Override
	public String getDescription() {
		return "Destroy every troop in one territory and claim it for your own, setting the number of troops to one" + "\n \n \" Mine \" ";
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getCurrentPlayer().addTerritory(target.getSelectedTerritory());
		target.getSelectedTerritory().setNbrOfUnits(1);		
	}

}
