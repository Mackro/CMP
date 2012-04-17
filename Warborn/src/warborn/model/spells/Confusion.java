package warborn.model.spells;

import java.awt.Color;

import warborn.model.Warborn;

public class Confusion extends Spell{

	public Confusion(int mana) {
		super(mana);
	}

	@Override
	public boolean validTarget(Warborn model) {
		return true;
	}

	@Override
	public String getName() {
		return "Confusion";
	}

	@Override
	public String getDescription() {
		return "Swaps the colors of players to increase confusion";
	}

	@Override
	public void invoke(Warborn model) {
		Color temp = model.getPlayer(0).getColor();
		for(int i = 1; i < model.getPlayers().length; i++){
			model.getPlayer(i-1).setColor(model.getPlayer(i).getColor());
		}
		model.getPlayer(model.getPlayers().length).setColor(temp);
	}
	
	@Override
	public boolean isInstant(){
		return true;
	}

}
