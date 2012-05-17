package warborn.model.spells;

public class Protect extends Spell {
	
	private final static String DESCRIPTION = "Protects target territory from being attacked or targeted by spells for one turn \n \n \"Always use protection \" ";
	
	private final static String NAME = "Protect";
	
	private Liveable protectedTerritory;
	
	public Protect(int mana) {
		super(mana);
	}

	@Override
	public void invoke(SpellTargetable target) {
		setTimer(target.getNumberOfPlayers()-1);
		protectedTerritory = target.getSelectedTerritory();
		protectedTerritory.setProtected(true);
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
	public void tick(SpellTargetable target){
		decrementTimer();
		if(getTimer() > 0){
			protectedTerritory.setProtected(true);
		}
	}
}
