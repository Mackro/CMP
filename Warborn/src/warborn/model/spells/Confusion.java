package warborn.model.spells;

import java.awt.Color;

public class Confusion extends Spell{
	
	private final static String DESCRIPTION = "Swaps the colors of players to increase confusion \"Change is a necessary step in evolution\"";
	
	private final static String NAME = "Confusion"; 

	public Confusion(int mana) {
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
		Color temp = target.getPlayer(0).getColor();
		for(int i = 1; i < target.getNumberOfPlayers(); i++){
			target.getPlayer(i-1).setColor(target.getPlayer(i).getColor());
		}
		target.getPlayer((target.getPlayers().length)-1).setColor(temp);
	}
	
	@Override
	public boolean isInstant(){
		return true;
	}

}
