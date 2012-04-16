package warborn.model.spells;

import warborn.model.Warborn;

public abstract class Spell {
	
	private int manaCost;
	
	public abstract boolean validTarget(Warborn model);
	public abstract String getName();
	public abstract String getDescription();
	public abstract void invoke (Warborn model);
	
	public Spell(int mana){
		manaCost = mana;
	}
	
	public int getManaCost(){
		return manaCost;
	}
	
	public String toString() {
		return getName();
	}
	
	public boolean isInstant(){
		return false;
	}
	
}
