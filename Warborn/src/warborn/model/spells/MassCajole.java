package warborn.model.spells;

public class MassCajole extends Spell {
	
	private final static String DESCRIPTION = "Destroy 1 troop in each enemy territory to a minimum of 1," +
			" each troop destroyed this way you get as reinforcements during your reinforcement phase " +
			"\" The grass is always greener on the other side \" ";
	
	private final static String NAME = "Mass Cajole";	
	private int bonusTroops;

	public MassCajole(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return true;
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
		setTimer(target.getNumberOfPlayers());
		for(Liveable territory : target.getTerritories()){
			if(territory.getOwner() != target.getCurrentPlayer()){
				bonusTroops++;
			}
		}
	}
	
	public void tick(SpellTargetable target){
		decrementTimer();
		if(getTimer() == 0){
			target.setNbrOfReinforcements(target.getNbrOfReinforcements() + bonusTroops);
		}
	}
	
	@Override
	public boolean isInstant(){
		return true;
	}
}
