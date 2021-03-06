package warborn.model.spells;

public class FireBall extends Spell {
	
	private final static String DESCRIPTION = "Destroy 3 troops in target territory to a minium of 1 \n \n \" Toast 'em \" ";
	private final static String NAME = "Fireball";
	
	public FireBall(int mana) {
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
		if(target.getSelectedTerritory().getNbrOfUnits() < 4){
			target.getSelectedTerritory().setNbrOfUnits(1);
		}
		else{
			target.getSelectedTerritory().setNbrOfUnits(target.getSelectedTerritory().getNbrOfUnits() - 3);
		}
	}

}
