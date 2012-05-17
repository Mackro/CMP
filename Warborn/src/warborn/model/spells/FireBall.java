package warborn.model.spells;

public class FireBall extends Spell {

	public FireBall(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return target.getSelectedTerritory().getOwner() != target.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "Fireball";
	}

	@Override
	public String getDescription() {
		return "Destroy 3 troops in target territory to a minium of 1 \n \n \" Toast 'em \" ";
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
