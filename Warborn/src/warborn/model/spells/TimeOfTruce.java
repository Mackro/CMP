package warborn.model.spells;

public class TimeOfTruce extends Spell {
	
	private final static String DESCRIPTION = "Protects all territories on the map from being attacked or targeted by spells until each controlling players turn \n \n \"Much work for making sure nothing happens \" "; 
	
	private final static String NAME = "Time Of Truce";

	public TimeOfTruce(int mana) {
		super(mana);
	}

	@Override
	public void invoke(SpellTargetable target) {
		this.setTimer(0);
		for(Liveable territory : target.getTerritories()){
			territory.setProtected(true);
		}
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
	
	public boolean isInstant(){
		return true;
	}
}
