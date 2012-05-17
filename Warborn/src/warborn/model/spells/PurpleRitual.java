package warborn.model.spells;

public class PurpleRitual extends Spell {
	
	private final static String DESCRIPTION = "Sacrifice your remaining reiforcements and destroy twice as many troops in target enemy territory to a minimum of 1. \n " +
			"Usable only during your reinforcement phase and you have more than 4 reinforcements \n \n \"You're of more use to me this way\" ";
	
	private final static String NAME = "Purple Ritual";

	public PurpleRitual(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return (target.getNbrOfReinforcements() <= 4) && (target.getSelectedTerritory().getOwner() != target.getCurrentPlayer()) && (target.getState() == 1);
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
		if(target.getSelectedTerritory().getNbrOfUnits() <= target.getNbrOfReinforcements()*2){
			target.getSelectedTerritory().setNbrOfUnits(1);
		}
		else{
			target.getSelectedTerritory().decrementUnits(target.getNbrOfReinforcements()*2);		
		}
		target.setNbrOfReinforcements(0);
	}	

}
