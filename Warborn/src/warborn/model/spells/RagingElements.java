package warborn.model.spells;

import warborn.model.Warborn;

public class RagingElements extends Spell {

	public RagingElements(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() != model.getCurrentPlayer();
	}

	@Override
	public String getName() {
		return "RagingElements";
	}

	@Override
	public String getDescription() {
		return "Destroy 1 troop in target territory  \n \n \" Achtung enraged titan \" ";
	}

	@Override
	public void invoke(Warborn model) {
		if(model.getSelectedTerritory().getNbrOfUnits() > 1){
			model.getSelectedTerritory().decrementUnit();
			model.getCurrentPlayer().changeMana(-this.getManaCost());
		}
	}

}
