package warborn.model.spells;

public class Deception extends Spell {
	
	private final static String description = "Destroy every troop in one territory and claim it for your own, setting the number of troops to one" + "\n \n \" Mine \" ";
	private final static String name = "Deception";
	
	public Deception(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer(); //&& model.getSelectedTerritory().hasConnection(model.getCurrentPlayer().);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void invoke(SpellTargetable target) {
		target.getCurrentPlayer().addTerritory(target.getSelectedTerritory());
		target.getSelectedTerritory().setNbrOfUnits(1);		
	}

}
