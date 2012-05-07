package warborn.model.spells;

import warborn.model.Warborn;

public class Purge extends Spell {

	public Purge(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return model.getSelectedTerritory().getOwner() != model.getCurrentPlayer(); //&& model.getSelectedTerritory().hasConnection(model.getCurrentPlayer().);
	}

	@Override
	public String getName() {
		return "Purge";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Destroy every troop in one territory and claim it for your own, setting the number of troops to one" + "\n \n \" Mine \" ";
	}

	@Override
	public void invoke(Warborn model) {
		model.getSelectedTerritory().setOwner(model.getCurrentPlayer());
		model.getSelectedTerritory().setNbrOfUnits(1);
		
	}

}
