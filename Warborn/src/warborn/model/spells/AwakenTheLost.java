package warborn.model.spells;

public class AwakenTheLost extends Spell {

	public AwakenTheLost(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(SpellTargetable target) {
		return true;
	}

	@Override
	public String getName() {
		return "Awaken The Lost";
	}

	@Override
	public String getDescription() {
		return "Add 1 troop to each territory you control during three rounds \n \n \" Wakey Wakey \" ";
	}

	@Override
	public void invoke(SpellTargetable target) {
		setTimer(target.getNumberOfPlayers()*3);
		for(Liveable territory : target.getTerritories()){
			if(territory.getOwner() == target.getCurrentPlayer()){
				territory.incrementUnit();
			}
		}
	}
	
	public void tick(SpellTargetable target){
		decrementTimer();
		if(getTimer() % target.getNumberOfPlayers() == 0){
			for(Liveable territory : target.getTerritories()){
				if(territory.getOwner() == target.getCurrentPlayer()){
					territory.incrementUnit();
				}
			}
		}
	}
	
	@Override
	public boolean isInstant(){
		return true;
	}
}
