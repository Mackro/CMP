package warborn.model.spells;

import warborn.model.Territory;
import warborn.model.Warborn;

public class AwakenTheLost extends Spell {

	public AwakenTheLost(int mana) {
		super(mana);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getCurrentPlayer() == model.getSelectedTerritory().getOwner();
	}

	@Override
	public String getName() {
		return "Awaken The Lost";
	}

	@Override
	public String getDescription() {
		return "Add 1 troop to each territory you control under three rounds \n \n \" Wakey Wakey \" ";
	}

	@Override
	public void invoke(Warborn model) {
		setTimer(model.getNumberOfPlayers()*3);
		for(Territory territory : model.getTerritories()){
			if(territory.getOwner() == model.getCurrentPlayer()){
				territory.incrementUnit();
			}
		}
	}
	
	public void tick(Warborn model){
		decrementTimer();
		if(getTimer() % model.getNumberOfPlayers() == 0){
			for(Territory territory : model.getTerritories()){
				if(territory.getOwner() == model.getCurrentPlayer()){
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
