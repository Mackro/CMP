package warborn.model.spells;

import warborn.model.Warborn;

public abstract class Spell {
	
	private int manaCost;
	public int timer;
	
	public abstract boolean validTarget(Warborn model);
	public abstract String getName();
	public abstract String getDescription();
	public abstract void invoke (Warborn model);
	
	public Spell(int mana, int time){
		manaCost = mana;
		timer = time;
	}
	
	public int getManaCost(){
		return manaCost;
	}
	
	public int getTimer(){
		return timer;
	}
	
	public void tick(){
		timer--;
	}
	
	public String toString() {
		return getName();
	}
	
	public boolean isInstant(){
		return false;
	}
	
}
